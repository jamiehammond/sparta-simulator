package com.sparta.model;

import com.sparta.configuration.Settings;

public class Bootcamp {

    private static int count;

    public Bootcamp() {
        super(Settings.CENTER_CAPACITY_BOOTCAMP.getValue(), Settings.CENTRE_GRACE_PERIOD_BOOTCAMP.getValue());
    }

    public static int getCount() {}


}