package com.sparta.model;

import com.sparta.configuration.Settings;
import com.sparta.utility.Randomizer;
import com.sparta.utility.TimeTracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class ClientRequirements {

    private final LocalDate startDate;
    private CourseType courseType;
    private final int traineesToHire;
    private boolean completed;
    private final ArrayList<Trainee> hiredTrainees;

    {
        this.startDate = TimeTracker.getCurrentDate();
        this.traineesToHire = Randomizer.generateRandomInt(Settings.CLIENT_HIRE_MIN.getValue(), Settings.CLIENT_HIRE_MAX.getValue());
        this.completed = false;
        this.hiredTrainees = new ArrayList<>();
    }

    public ClientRequirements() {
        this.courseType = Randomizer.getCourseType();
    }

    public ClientRequirements(CourseType courseType) {
        this.courseType = courseType;
    }

    public boolean isDueDate() {
        return !TimeTracker.getCurrentDate().isAfter(startDate.plusMonths(Settings.CLIENT_REQUIREMENT_EXPIRY_TIME.getValue()));
    }

    public ArrayList<Trainee> getHiredTrainees(){
        ArrayList<Trainee> trainees = new ArrayList<>(hiredTrainees);
        hiredTrainees.clear();
        return trainees;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }


    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Collection<Trainee> addTrainees(Collection<Trainee> trainees) {
        LinkedList<Trainee> remainingTrainees = new LinkedList<>(trainees);
        LinkedList<Trainee> currentlyHiredTrainees = new LinkedList<>();
        while (remainingTrainees.peek() != null && getHiredTrainees().size()<traineesToHire) {
            assert remainingTrainees.peek() != null;
            if (remainingTrainees.peek().getCourseType() == this.courseType) {
                currentlyHiredTrainees.add(remainingTrainees.poll());
            }
        }
        if (getHiredTrainees().size() == traineesToHire) {
            completed = true;
        }
        return currentlyHiredTrainees;
    }

    public void checkIfComplete() {
            completed = traineesToHire == hiredTrainees.size();
    }
}
