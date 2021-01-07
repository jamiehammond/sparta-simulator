package com.sparta.model;

public class Trainee {
    private int traineeID;
    private static int count=0;
    private CourseType courseType;

    public Trainee() {
        this.traineeID =count;

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
}
