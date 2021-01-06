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
        Printer.greeting();
        TimeTracker.startSimulation();
        while (TimeTracker.hasNextMonth()) {
            if (TimeTracker.getMonth() % Settings.CENTER_OPENING_FREQUENCY.getValue() == 0) {
                spartaGlobal.openCentre();
            }
            if (TimeTracker.getMonth() % Settings.NEW_TRAINEE_FREQUENCY.getValue() == 0) {
                int traineesToGenerate = Randomizer.generateRandomInt(Settings.NEW_TRAINEE_MIN.getValue(), Settings.NEW_TRAINEE_MAX.getValue());
                TraineeController.generateTrainees(spartaGlobal.getWaitingList(), traineesToGenerate);
                Printer.printProgress(spartaGlobal);
            }
            spartaGlobal.assignTrainees();
            Delayer.delay(Settings.MONTH_IN_MS.getValue());
            TimeTracker.nextMonth();
        }
        Printer.printProgress(spartaGlobal);
    }

}