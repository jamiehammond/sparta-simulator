package com.sparta.controller;

import com.sparta.model.Bootcamp;
import com.sparta.model.Centre;
import com.sparta.model.CentreType;
import com.sparta.utility.Randomizer;

public class CentreFactory {

    public static Centre getRandomCentre() {
        CentreType centreType = CentreType.values()[Randomizer.generateRandomInt(0, CentreType.values().length - 1)];
        return centreFactory(centreType);
    }

    public static Centre centreFactory(CentreType centreType) {
        switch(centreType) {
            case BOOTCAMP:
                return new Bootcamp();
            case TECH_CENTRE:
                return new TechCentre();
            case TRAINING_HUB:
                return new TrainingHub();
        }
        return null;
    }
}