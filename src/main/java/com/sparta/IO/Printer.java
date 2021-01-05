package com.sparta.IO;

import com.sparta.utility.Settings;
import com.sparta.utility.TimeTracker;

public class Printer {

    public static void greeting(){
        System.out.println("Welcome to the Sparta simulator");
    }

    public static void simulationTime(){
        System.out.println("Enter simulation time in Months (Press enter to use default value: "+Settings.getSimulationTime);
    }

    public static void centreOpeningFrequency(){
        System.out.println("Enter centre opening frequency (Press enter to use default value: "+ Settings.getCentreOpeningFrequency);
    }

    public static void centreCapacity(){
        System.out.println("Enter centre capacity (Press enter to use default value: "+ Settings.getCentreCapacity);
    }
    public static void newTraineeMin(){
        System.out.println("Enter lower bound for new trainee generation range (Press enter to use default value: "+ Settings.getNewTraineeMin);
    }

    public static void newTraineeMax(){
        System.out.println("Enter upper bound for new trainee generation range (Press enter to use default value: "+ Settings.getNewTraineeMax);
    }

    public static void newTraineeFrequency(){
        System.out.println("Enter new trainee frequency in months (Press enter to use default value: "+ Settings.getNewTraineeFrequency);
    }

    public static void centreAdmittanceMin(){
        System.out.println("Enter lower bound for centre admittance (Press enter to use default value: "+ Settings.getCentreAdmittanceMin);
    }

    public static void centreAdmittanceMax(){
        System.out.println("Enter upper bound for centre admittance (Press enter to use default value: "+ Settings.getCentreAdmittanceMax);
    }

    public static void centreAdmittanceFrequency(){
        System.out.println("Enter centre admittance frequency in months (Press enter to use default value: "+ Settings.getCentreAdmittanceFrequency);
    }

    public static void monthDelay(){
        System.out.println("Enter how many seconds represent one month (Press enter to use default value: "+ Settings.getMonthDelay);
    }

    public static void areValuesCorrectToRun(){
        System.out.println("Are these values correct to run the simulation? (Y/N) ");
    }

    public static void currentMonth(){
        System.out.println("Current Month: "+TimeTracker.getCurrentMonth());
    }

    public static void openCentres(){
        System.out.println("Number of open centres: "+TimeTracker.getOpenCentres());
    }

    public static void fullCentres(){
        System.out.println("Number of full centres: "+TimeTracker.getFullCentres());
    }

    public static void traineesInTraining(){
        System.out.println("Number of trainees in training: "+TimeTracker.getTraineesInTraining());
    }

    public static void traineesInWaitingList(){
        System.out.println("Number of trainees in waiting list: "+TimeTracker.getTraineesInWaitingList());
    }
}
