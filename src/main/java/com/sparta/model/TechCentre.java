package com.sparta.model;

import com.sparta.configuration.Settings;

public class TechCentre {



    public TechCentre() {
        super(Settings.CENTER_CAPACITY_TECH_CENTRE.getValue(), Settings.CENTRE_GRACE_PERIOD_TECH_CENTRE.getValue());
    }
}
