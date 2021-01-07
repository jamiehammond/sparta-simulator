package com.sparta.main;

import com.sparta.IO.Printer;
import com.sparta.configuration.Settings;
import com.sparta.controller.TraineeController;
import com.sparta.model.Company;
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
        Printer.printProgress(spartaGlobal);

        while (TimeTracker.hasNextMonth()) {
            Delayer.delay(Settings.MONTH_IN_MS.getValue());
            if (TimeTracker.getMonthsPassed() % Settings.CENTER_OPENING_FREQUENCY.getValue() == 0) {
                spartaGlobal.openCentre();
            }
            if (TimeTracker.getMonthsPassed() % Settings.NEW_TRAINEE_FREQUENCY.getValue() == 0) {
                int traineesToGenerate = Randomizer.generateRandomInt(Settings.NEW_TRAINEE_MIN.getValue(), Settings.NEW_TRAINEE_MAX.getValue());
                TraineeController.generateTrainees(spartaGlobal.getWaitingList(), traineesToGenerate);
            }
            spartaGlobal.assignTrainees();
            TimeTracker.nextMonth();
            Printer.printProgress(spartaGlobal);
        }
//        Printer.printProgress(spartaGlobal);
    }

}