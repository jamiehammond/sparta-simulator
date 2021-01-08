package com.sparta.main;

import com.sparta.IO.Printer;
import com.sparta.configuration.Settings;
import com.sparta.controller.TraineeController;
import com.sparta.model.Company;
import com.sparta.model.ReportPack;
import com.sparta.utility.Delayer;
import com.sparta.utility.Randomizer;
import com.sparta.utility.TimeTracker;

public class App 
{
    public static void main( String[] args ) {

        Company spartaGlobal = new Company();

        // TODO : User input code from inputManager here
        TimeTracker.startSimulation();
        Printer.greeting();
        while (TimeTracker.hasNextMonth()) {
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
//        ReportPack.generateReport(spartaGlobal).print();
//        Printer.printProgress(spartaGlobal);
    }

}