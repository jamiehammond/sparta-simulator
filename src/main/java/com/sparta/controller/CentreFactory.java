package com.sparta.controller;

import com.sparta.model.*;
import com.sparta.utility.Randomizer;

public class CentreFactory {

    public static Centre createCentre(CentreType centreType){
        return centreFactory(centreType);
    }

    private static Centre centreFactory(CentreType centreType) {
        switch(centreType) {
            case BOOTCAMP:
                return new Bootcamp();
            case TECH_CENTRE:
                return new TechCentre(Randomizer.getCourseType());
            case TRAINING_HUB:
                return new TrainingHub();
        }
        return null;
    }

    public static Centre getRandomCentre() {
        return centreFactory(Randomizer.getCentreType());
    }
}