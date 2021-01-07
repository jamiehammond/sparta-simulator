package com.sparta.model;

import com.sparta.configuration.Settings;
import com.sparta.utility.Randomizer;

public class TechCentre extends Centre {

    private CourseType courseType;

    public TechCentre() {
        super(Settings.CENTER_CAPACITY_TECH_CENTRE.getValue(), Settings.CENTER_GRACE_PERIOD_TECH_CENTRE.getValue());
        this.courseType = Randomizer.getRandomCourseType();
    }

    @Override
    public CourseType getCourseType() {
        return courseType;
    }

}
