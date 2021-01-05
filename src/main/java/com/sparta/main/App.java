package com.sparta.main;

import com.sparta.configuration.Settings;

public class App 
{
    public static void main( String[] args )
    {
        Company spartaGlobal = new Company();

        // TODO : User input code from inputManager here
        while (TimeTracker.hasNextMonth()) {
            Printer.printProgress();
            if (TimeTracker.getMonth() % Settings.CENTER_OPENING_FREQUENCY.getValue() == 0) {
                spartaGlobal.openCentre();
            }
            if (TimeTracker.getMonth() % Settings.NEW_TRAINEE_FREQUENCY_IN_MONTHS == 0) {
                int traineesToGenerate = Randomizer.getRandomInt(Settings.NEW_TRAINEE_MIN.getValue(), Settings.NEW_TRAINEE_MAX.getValue());
                TraineeController.generateTrainees(spartaGlobal.getWaitingList(), traineesToGenerate);
            }
            spartaGlobal.assignTrainees();
            Delayer.delay(Settings.MONTH_DELAY_IN_SECONDS.getValue());
        }
        Printer.printProgress();
        Settings.CENTER_ADMITTANCE_FREQUENCY.getValue();
    }
}