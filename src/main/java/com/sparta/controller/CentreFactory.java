package com.sparta.controller;

import com.sparta.model.*;
import com.sparta.utility.Randomizer;

import java.util.HashMap;

public class CentreFactory {

    public static HashMap<CentreType, Integer> availableCentreTypes; //CentreType, Counter
    public static HashMap<CentreType, Integer> lifeTimeLimit; //CentreType, limit of objects

    static {
        availableCentreTypes = new HashMap<>();
        lifeTimeLimit = new HashMap<>();
        for (CentreType value : CentreType.values()) {
            availableCentreTypes.put(value, 0);
            lifeTimeLimit.put(value, value.getLifeTimeLimit());
        }
    }

    private static Centre createCentre(CentreType centreType) {
        return centreFactory(centreType);
    }

    private static Centre centreFactory(CentreType centreType) {
        switch (centreType) {
            case BOOTCAMP:
                return new Bootcamp();
            case TECH_CENTRE:
                return new TechCentre();
            case TRAINING_HUB:
                return new TrainingHub();
        }
        return null;
    }

    public static Centre getRandomCentre() {
        CentreType randomCentre = Randomizer.getRandomCentreType(availableCentreTypes.keySet());
        if (randomCentre != null) {
            if (availableCentreTypes.get(randomCentre) >= lifeTimeLimit.get(randomCentre) && lifeTimeLimit.get(randomCentre) != -1) {
                availableCentreTypes.remove(randomCentre);
                return getRandomCentre();
            } else {
                Centre newCentre = createCentre(randomCentre);
                availableCentreTypes.put(randomCentre, availableCentreTypes.get(randomCentre) + 1);
                return newCentre;
            }
        }
        return null;
    }
}