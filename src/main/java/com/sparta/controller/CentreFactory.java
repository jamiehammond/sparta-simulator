package com.sparta.controller;

import com.sparta.model.*;
import com.sparta.utility.Randomizer;

import java.util.ArrayList;

public class CentreFactory {

    public static ArrayList<CentreType> centreTypes;
    public static Centre createCentre(CentreType centreType){
        return centreFactory(centreType);
    }
    static {
        centreTypes=new ArrayList<>();
        //to be instatianted with centreType.values()
    }
    private static Centre centreFactory(CentreType centreType) {
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

    public static Centre getRandomCentre() {
         return null;
    }
}