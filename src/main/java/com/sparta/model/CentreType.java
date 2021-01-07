package com.sparta.model;

public enum CentreType {
    TRAINING_HUB("Training Hub"),
    BOOTCAMP("Bootcamp"),
    TECH_CENTRE("Tech Centre");

    private final String centreName;

    CentreType(String centreName) {
        this.centreName = centreName;
    }

    public String getCentreName() {
        return centreName;
    }
}
