package com.sparta.model;

import com.sparta.configuration.Settings;
import com.sparta.utility.TimeTracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public abstract class Centre {
    private final int centreId;
    private final int capacity;
    private final ArrayList<Trainee> trainees;
    private static int centreCount;
    private CourseType courseType;
    private final int gracePeriod;
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

    public int getCapacity() {
        return capacity;
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
        trainee.startTraining();
        trainees.add(trainee);
    }

    public int getCentreId() {
        return centreId;
    }

    public boolean isOverGracePeriod(){
        complyToGracePeriod();
        return TimeTracker.getCurrentDate().isAfter(graceStartingDate.plusMonths(gracePeriod));
    }

    public CourseType getCourseType() {
        return courseType;
    }

    private void complyToGracePeriod() {
        if (trainees.size() < Settings.CENTRE_GRACE_MIN_TRAINEES_IN_TRAINING.getValue()) {
            this.graceStartingDate = TimeTracker.getCurrentDate();
        }
    }

    public abstract Collection<? extends Trainee> getTraineesByCourseType(CourseType courseType);

    protected void setCourseType(CourseType courseType){
        this.courseType = courseType;
    }

    public LinkedList<Trainee> getGraduates() {
        LinkedList<Trainee> graduates = new LinkedList<>();
        for (Trainee trainee : trainees) {
            if (trainee.isGraduate()) {
                graduates.add(trainee);
            }
        }
        trainees.removeAll(graduates);
        return graduates;
    }
}
