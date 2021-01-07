package com.sparta.model;

import com.sparta.configuration.Settings;

public class TechCentre extends Centre {

    private CourseType courseType;

    public TechCentre(CourseType courseType) {
        super(Settings.CENTER_CAPACITY_TECH_CENTRE.getValue(), Settings.CENTER_GRACE_PERIOD_TECH_CENTRE.getValue());
        this.courseType = courseType;
    }

    @Override
    public CourseType getCourseType() {
        return courseType;
    }

}
