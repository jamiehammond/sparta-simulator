package com.sparta.model;

import com.sparta.configuration.Settings;
import com.sparta.utility.Randomizer;

import java.util.Collection;
import java.util.Collections;

public class TechCentre extends Centre {

    public TechCentre() {
        super(Settings.CENTRE_CAPACITY_TECH_CENTRE.getValue(), Settings.CENTRE_GRACE_PERIOD_TECH_CENTRE.getValue());
        super.setCourseType(Randomizer.getCourseType());
    }

    @Override
    public Collection<? extends Trainee> getTraineesByCourseType(CourseType courseType) {
        if(courseType == super.getCourseType()){
            return super.getTraineesList();
        }
        return Collections.emptyList();
    }

}
