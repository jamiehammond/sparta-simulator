package com.sparta.model;

import com.sparta.configuration.Settings;
import java.util.ArrayList;

public abstract class Centre {
    private int centreId;
    private final int capacity;
    private ArrayList<Trainee> trainees;
    private static int centreCount;
    private CourseType courseType;
    private int gracePeriod;
    private LocalDate graceStartingDate;

    static {
        centreCount=0;
    }

    public Centre (int capacity, int gracePeriod) {
        this.capacity = capacity;
        trainees  = new ArrayList<>();
        this.gracePeriod = gracePeriod;
        this.centreId=centreCount;
        centreCount++;
        this.courseType = null;
        this.graceStartingDate = null;
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
    public ArrayList<Trainee> getTraineesByCourseType(CourseType courseType){
        ArrayList<Trainee> traineesWithGivenCourseType = new ArrayList<>();
        for(int i=0;i<trainees.size();i++){
            if(trainees.get(i).getCourseType() == courseType){
                traineesWithGivenCourseType.add(trainees.get(i));
            }
        }
        return traineesWithGivenCourseType;
    }

    public boolean isOverGracePeriod(){}
}
