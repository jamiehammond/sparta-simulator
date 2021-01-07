package com.sparta.model;

import java.util.HashMap;
import java.util.HashSet;

public enum CentreType {
    TRAINING_HUB("Training Hub", new TrainingHub()),
    BOOTCAMP("Bootcamp", new Bootcamp()),
    TECH_CENTRE("Tech Centre", new TechCentre());

    private final String centreName;
    private final Centre centre;

    CentreType(String centreName, Centre centre) {
        this.centreName = centreName;
        this.centre = centre;
    }

    public String getCentreName() {
        return centreName;
    }

    public Centre getInstance(){
        return centre;
    }

    public static CentreType getCentreType(Centre centre){
        for (CentreType value : CentreType.values()) {
            if(value.getInstance().getClass().isInstance(centre)){
                return value;
            }
        }
        throw new IllegalStateException("Centre type not registered.");
    }
}
