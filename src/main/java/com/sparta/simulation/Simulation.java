package com.sparta.simulation;

import com.sparta.IO.Printer;
import com.sparta.configuration.Settings;
import com.sparta.model.Company;
import com.sparta.model.ReportPack;
import com.sparta.output.FileExporter;
import com.sparta.utility.*;

import java.io.FileReader;
import java.io.IOException;

public class Simulation {

    public static void start() {
        Company spartaGlobal = new Company();
        initializeSimulation();

        printProgress(spartaGlobal); // printing the initial state

        while (TimeTracker.hasNextMonth()) {
            onStep();
            openCentre(spartaGlobal);
            generateTrainees(spartaGlobal);
            graduateTrainees(spartaGlobal);
            checkCentresForOpening(spartaGlobal);
            assignTraineesToCentres(spartaGlobal);
            checkCentresForClosing(spartaGlobal);
            generateClients(spartaGlobal);
            fulfillRequirements(spartaGlobal);
            TimeTracker.nextMonth();
            ReportPack report = generateStepByStepReport(spartaGlobal);
            if(report != null){
                outputReport(report, true); // will be null if SimulationMode = FAST_FORWARD
            }
        }
        printProgress(spartaGlobal);
        ReportPack finalReport = generateFinalReport(spartaGlobal); // will be null if SimulationMode = STEP_BY_STEP
        if(finalReport != null){
            outputReport(finalReport, false);
        }
    }

    private static void outputReport(ReportPack report, boolean stepByStep) {
        if(!stepByStep) {
            if (Settings.REPORT_OUTPUT.getValue() == 0) {
                try {
                    FileExporter.writeReportToFile(report, "src/main/resources/report.txt");
                    Printer.print(TextColor.ANSI_GREEN + "The simulation report has been successfully exported to " +
                            TextColor.ANSI_BLUE + "report.txt" + TextColor.ANSI_RESET + ".");
                } catch (IOException e) {
                    System.err.println("Report writing has failed!\nReport output will be printed in the console.");
                    Delayer.delay(1000);
                    report.print();
                }
            } else {
                report.print();
            }
        }else{
            report.print();
        }
    }

    private static ReportPack generateFinalReport(Company company) {
        if (ModeChooser.getSimulationMode() == SimulationMode.FAST_FORWARD) {
            return ReportPack.generateReport(company);
        }
        return null;
    }

    private static ReportPack generateStepByStepReport(Company company) {
        if (ModeChooser.getSimulationMode() == SimulationMode.STEP_BY_STEP) {
            return ReportPack.generateReport(company);
        }
        return null;
    }

    private static void checkCentresForOpening(Company company) {
        company.checkCentresForOpening();
    }

    private static void generateClients(Company company) {
        if (TimeTracker.getMonthsPassed() > Settings.CLIENT_FIRST_CLIENT_AFTER_FIRST_MONTHS.getValue()) {
            if (Randomizer.getBoolean()) {
                company.addClient();
            }
        }
    }

    private static void fulfillRequirements(Company company) {
        if (company.getHappyClients().size() > 0) {
            company.fulfillClientRequirements();
        }
    }

    private static void checkCentresForClosing(Company company) {
        company.checkCentresForClosing();
    }

    private static void graduateTrainees(Company company) {
        company.graduateTrainees();
    }

    private static void assignTraineesToCentres(Company company) {
        company.assignTrainees();
    }

    private static void generateTrainees(Company company) {
        company.gatherNewTrainees();
    }

    private static void initializeSimulation() {
        TimeTracker.startSimulation();
        Printer.greeting();
    }

    /**
     * This method is checking the configured simulation mode from
     * the configuration file where {@link Settings#SIMULATION_STEP_BY_STEP}
     * is 0 if the method is FAST_FORWARD, else is STEP_BY_STEP
     * <p>
     * Based on the simulation mode, if it is STEP_BY_STEP
     * it will call the delayer to simulate the time passing
     * within the simulation.
     */
    private static void onStep() {
        switch (ModeChooser.getSimulationMode()) {
            case FAST_FORWARD: {
                break;
            }
            case STEP_BY_STEP: {
                Delayer.delay(Settings.MONTH_IN_MS.getValue());
                break;
            }
        }
    }

    private static void printProgress(Company company) {
        Printer.printProgress(company);
    }

    private static void oneCycle() {

    }

    private static void openCentre(Company company) {
        if (TimeTracker.getMonthsPassed() % Settings.CENTER_OPENING_FREQUENCY.getValue() == 0) {
            company.openCentre();
        }
    }
}
