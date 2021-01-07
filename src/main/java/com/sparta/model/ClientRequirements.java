package com.sparta.model;

import com.sparta.configuration.Settings;
import com.sparta.utility.Randomizer;

import java.time.LocalDate;

public class ClientRequirements {

    private LocalDate startDate;
    private CourseType courseType;
    private int traineesToHire;
    private boolean completed;

    public ClientRequirements(LocalDate startDate, CourseType courseType, int traineesToHire, boolean completed) {
        this.startDate = startDate;
        this.courseType = courseType;
        this.traineesToHire = traineesToHire;
        this.completed = completed;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
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

    public void setTraineesToHire(int traineesToHire) {
        this.traineesToHire = traineesToHire;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
