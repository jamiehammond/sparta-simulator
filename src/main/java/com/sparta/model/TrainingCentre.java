package com.sparta.model;

import com.sparta.configuration.Settings;

public class TrainingCentre {

    public TrainingCentre() {
        super(Settings.CENTER_CAPACITY_TRAINING_CENTRE.getValue(), Settings.CENTRE_GRACE_PERIOD_TRAINING_CENTRE.getValue());
    }
}
