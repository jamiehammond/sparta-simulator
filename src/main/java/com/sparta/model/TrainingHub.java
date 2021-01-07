package com.sparta.model;

import com.sparta.configuration.Settings;

public class TrainingHub extends Centre {
    public TrainingHub() {
        super(Settings.CENTER_CAPACITY_TRAINING_CENTRE.getValue(), Settings.CENTRE_GRACE_PERIOD_TRAINING_CENTRE.getValue());
    }
}
