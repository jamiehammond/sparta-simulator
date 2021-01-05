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
    public static void main( String[] args )
    {

        // TODO : User input code from inputManager here
        while (TimeTracker.hasNextMonth()) {
            //Printer.printProgress();
            if (TimeTracker.getMonth() % Settings.CENTER_OPENING_FREQUENCY.getValue() == 0) {
                Company.openCentre();
            }
            if (TimeTracker.getMonth() % Settings.NEW_TRAINEE_FREQUENCY.getValue() == 0) {
                int traineesToGenerate = Randomizer.generateRandomInt(Settings.NEW_TRAINEE_MIN.getValue(), Settings.NEW_TRAINEE_MAX.getValue());
                TraineeController.generateTrainees(Company.getWaitingList(), traineesToGenerate);
            }
            Company.assignTrainees();
            Delayer.delay(Settings.MONTH_IN_MS.getValue());
        }
        //Printer.printProgress();
        Settings.CENTER_ADMITTANCE_FREQUENCY.getValue();
    }
}