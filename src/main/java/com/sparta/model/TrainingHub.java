package com.sparta.model;

import com.sparta.configuration.Settings;

import java.util.Collection;

public class TrainingHub extends Centre {
    public TrainingHub() {
        super(Settings.CENTRE_CAPACITY_TRAINING_CENTRE.getValue(), Settings.CENTRE_GRACE_PERIOD_TRAINING_CENTRE.getValue());
    }

    @Override
    public Collection<? extends Trainee> getTraineesByCourseType(CourseType courseType) {
        return super.getTraineesList();
    }
}
