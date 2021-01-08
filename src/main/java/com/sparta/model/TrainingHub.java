package com.sparta.model;

import com.sparta.configuration.Settings;

import java.util.Collection;

public class TrainingHub extends Centre {

    private static int count;

    static{
        count = 0;
    }

    public TrainingHub() {
        super(Settings.CENTRE_CAPACITY_TRAINING_CENTRE.getValue(), Settings.CENTRE_GRACE_PERIOD_TRAINING_CENTRE.getValue());
        count++;
    }

    public static int getCentreCount(){
        return count;
    }

    @Override
    public Collection<? extends Trainee> getTraineesByCourseType(CourseType courseType) {
        return super.getTraineesList();
    }
}
