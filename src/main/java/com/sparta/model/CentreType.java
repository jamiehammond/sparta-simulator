package com.sparta.model;

public enum CentreType {
    TRAINING_HUB("Training Hub", new TrainingHub()),
    BOOTCAMP("Bootcamp", new Bootcamp()),
    TECH_CENTRE("Tech Centre", new TechCentre(CourseType.values()[0]));

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
}
