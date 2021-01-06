package com.sparta.model;

import com.sparta.configuration.Settings;
import java.util.ArrayList;

public class Centre {
    private int centreID;
    private final int capacity= Settings.CENTER_CAPACITY.getValue();
    public static ArrayList<Trainee> trainees = new ArrayList<>();
    public int traineeCount=0;

    public static ArrayList<Trainee> getTraineesList(){
        return trainees;
    }

    public int getNumberOfTrainees() {
        int traineeInProgress=0;
        for (Trainee trainee : trainees) {
            traineeInProgress=trainee.getCount();
        }
        traineeCount=traineeInProgress;
        return traineeInProgress;
    }

    public boolean isFull() {
        if (getCapacityCount()>0) {
            return false;
        }
        return true;
    }

    private int getCapacityCount () {
        int currentCapacity=0;
        currentCapacity = capacity - traineeCount;
        return currentCapacity;
    }

    public void addTrainee(Trainee trainee)  {
        trainees.add(trainee);
    }


}
