package com.sparta.model;

import com.sparta.configuration.Settings;
import com.sparta.utility.Randomizer;
import com.sparta.utility.TimeTracker;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClientRequirements {

    private final LocalDate startDate;
    private CourseType courseType;
    private final int traineesToHire;
    private boolean completed;
    private final ArrayList<Trainee> hiredTrainees;

    public ClientRequirements() {
        this.startDate = TimeTracker.getCurrentDate();
        this.courseType = Randomizer.getCourseType();
        this.traineesToHire = Randomizer.generateRandomInt(Settings.CLIENT_HIRE_MIN.getValue(), Settings.CLIENT_HIRE_MAX.getValue());
        this.completed = false;
        this.hiredTrainees = new ArrayList<>();
    }

    public ArrayList<Trainee> getHiredTrainees(){return hiredTrainees;}

    public void addTrainee(Trainee trainee){hiredTrainees.add(trainee);}

    public LocalDate getStartDate() {
        return startDate;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public int getTraineesToHire() {
        return traineesToHire;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
