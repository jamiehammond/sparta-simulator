package com.sparta.model;

import com.sparta.utility.Randomizer;

public class Trainee {
    private int traineeID;
    private static int count=0;
    private CourseType courseType;

    public Trainee() {
        this.traineeID = count;
        this.courseType = getRandomCourseType();
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

    private CourseType getRandomCourseType() {
        return CourseType.values()[Randomizer.generateRandomInt(0, CourseType.values().length - 1)];
    }
}
