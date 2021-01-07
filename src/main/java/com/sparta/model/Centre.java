package com.sparta.model;

import com.sparta.configuration.Settings;
import com.sparta.utility.TimeTracker;

import java.time.LocalDate;
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
    public ArrayList<Trainee> getTraineesByCourseType(CourseType courseType) {
        if (this.courseType != courseType) {
            ArrayList<Trainee> traineesWithGivenCourseType = new ArrayList<>();
            for (int i = 0; i < trainees.size(); i++) {
                if (trainees.get(i).getCourseType() == courseType) {
                    traineesWithGivenCourseType.add(trainees.get(i));
                }
            }
            return traineesWithGivenCourseType;
        }else{
            return trainees;
        }
    }

    public boolean isOverGracePeriod(){
        complyToGracePeriod();
        return TimeTracker.getCurrentDate().isAfter(graceStartingDate.plusMonths(gracePeriod));
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    private void complyToGracePeriod() {
        if (trainees.size() < Settings.CENTER_GRACE_MIN_TRAINEES) {
            this.graceStartingDate = TimeTracker.getCurrentDate();
        }
    }

}
