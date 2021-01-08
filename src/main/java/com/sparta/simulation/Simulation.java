package com.sparta.simulation;

import com.sparta.IO.Printer;
import com.sparta.configuration.Settings;
import com.sparta.controller.TraineeController;
import com.sparta.model.Company;
import com.sparta.model.ReportPack;
import com.sparta.utility.Delayer;
import com.sparta.utility.ModeChooser;
import com.sparta.utility.Randomizer;
import com.sparta.utility.TimeTracker;

public class Simulation {

    public static void start(){
        Company spartaGlobal = new Company();
        initializeSimulation();

        printProgress(spartaGlobal); // printing the initial state

        while (TimeTracker.hasNextMonth()) {
            onStep();
//            Delayer.delay(Settings.MONTH_IN_MS.getValue());
            if (TimeTracker.getMonthsPassed() % Settings.CENTER_OPENING_FREQUENCY.getValue() == 0) {
                spartaGlobal.openCentre();
            }
            if (TimeTracker.getMonthsPassed() % Settings.NEW_TRAINEE_FREQUENCY.getValue() == 0) {
                int traineesToGenerate = Randomizer.generateRandomInt(Settings.NEW_TRAINEE_MIN.getValue(), Settings.NEW_TRAINEE_MAX.getValue());
                TraineeController.generateTrainees(spartaGlobal.getWaitingList(), traineesToGenerate);
            }
            spartaGlobal.assignTrainees();
            spartaGlobal.graduateTrainees();
            spartaGlobal.checkCentresForClosing();
            if (TimeTracker.getMonthsPassed() > Settings.CLIENT_FIRST_CLIENT_AFTER_FIRST_MONTHS.getValue()) {
                if (Randomizer.getBoolean()) {
                    spartaGlobal.addClient();
                }
                if (spartaGlobal.getHappyClients().size() > 0) {
                    spartaGlobal.fulfillClientRequirements();
                }
            }
            TimeTracker.nextMonth();
        }
        ReportPack.generateReport(spartaGlobal).print();
//        Printer.printProgress(spartaGlobal);
    }

    private static void initializeSimulation(){
        TimeTracker.startSimulation();
        Printer.greeting();
    }

    /**
     * This method is checking the configured simulation mode from
     * the configuration file where {@link Settings#SIMULATION_STEP_BY_STEP}
     * is 0 if the method is FAST_FORWARD, else is STEP_BY_STEP
     *
     * Based on the simulation mode, if it is STEP_BY_STEP
     * it will call the delayer to simulate the time passing
     * within the simulation.
     */
    private static void onStep(){
        switch (ModeChooser.getSimulationMode()){
            case FAST_FORWARD:{
                break;
            }
            case STEP_BY_STEP:{
                Delayer.delay(Settings.MONTH_IN_MS.getValue());
                break;
            }
        }
    }

    private static void printProgress(Company company){
        Printer.printProgress(company);
    }

    private static void oneCycle(){

    }
}
