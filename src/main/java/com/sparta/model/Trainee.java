package com.sparta.model;

import com.sparta.configuration.Settings;
import com.sparta.utility.Randomizer;
import com.sparta.utility.TimeTracker;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Trainee {
    private final int traineeID;
    private static int count=0;
    private final CourseType courseType;
    private LocalDate startDate;
    private LocalDate graduationDate;

    public Trainee() {
        this.traineeID = count;
        this.courseType = Randomizer.getCourseType();
        this.startDate = null;
        this.graduationDate = null;
        count++;
    }
    public int getTraineeID() {
        return traineeID;
    }

    public int getCount() {
        return count;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public boolean isGraduate() {
        return graduationDate.isBefore(TimeTracker.getCurrentDate()) || graduationDate.isEqual(TimeTracker.getCurrentDate());
    }

    public void startTraining() {
        startDate = TimeTracker.getCurrentDate();
        graduationDate = startDate.plusMonths(Settings.NEW_TRAINEE_TRAINING_TIME_IN_MONTHS.getValue());
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public static Collection<Trainee> generateTrainees(int numberOfTrainees) {
        ArrayList<Trainee> trainees = new ArrayList<>();
        for (int i = 0; i < numberOfTrainees; i++) {
             trainees.add(new Trainee());
        }
        return trainees;
    }
}