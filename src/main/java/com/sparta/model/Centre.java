package com.sparta.model;

import com.sparta.configuration.Settings;
import java.util.ArrayList;

public class Centre {
    private int centreId;
    private final int capacity;
    private ArrayList<Trainee> trainees;
    private static int centreCount;

    static {
        centreCount=0;
    }

    public Centre () {
        this.capacity = Settings.CENTER_CAPACITY.getValue();
        trainees  = new ArrayList<>();
        this.centreId=centreCount;
        centreCount++;
    }

    public ArrayList<Trainee> getTraineesList(){
        return trainees;
    }

    public int countTraineesInTraining(){
        return trainees.size();
    }

    public boolean isFull() {
        return !(getRemainingCapacity()>0);
    }

    private int getRemainingCapacity() {
        return capacity - trainees.size();
    }

    public void addTrainee(Trainee trainee)  {
        trainees.add(trainee);
    }

    public int getCentreId() {
        return centreId;
    }
}
