package com.sparta.model;

import java.util.HashMap;
import java.util.HashSet;

public enum CentreType {
    TRAINING_HUB("Training Hub", -1 ,  new TrainingHub()),
    BOOTCAMP("Bootcamp", 2, new Bootcamp()),
    TECH_CENTRE("Tech Centre",-1, new TechCentre());

    private final String centreName;
    private final Centre centre;
    private final int lifeTimeLimit;

    CentreType(String centreName,int lifeTimeLimit, Centre centre) {
        this.centreName = centreName;
        this.centre = centre;
        this.lifeTimeLimit = lifeTimeLimit;
    }

    public int getLifeTimeLimit(){
        return this.lifeTimeLimit;
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
