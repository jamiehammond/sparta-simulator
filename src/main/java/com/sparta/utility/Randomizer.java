package com.sparta.utility;

import com.sparta.configuration.Settings;
import com.sparta.model.Centre;
import com.sparta.model.CentreType;
import com.sparta.model.CourseType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public static int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    //to be renamed "static int getNewTrainees()"
    public static int getNewTrainees() {
        return generateRandomInt(Settings.NEW_TRAINEE_MIN.getValue(), Settings.NEW_TRAINEE_MAX.getValue());
    }

    private static Collection<Integer> getArrayInRange(int size, int lower, int higher) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            integers.add(Randomizer.generateRandomInt(lower, higher));
        }
        return integers;
    }

    public static Collection<Integer> getCentreAllowanceArray(int size) {
        return getArrayInRange(size, Settings.CENTER_ADMITTANCE_MIN.getValue(), Settings.CENTER_ADMITTANCE_MAX.getValue());
    }

    public static CourseType getCourseType() {
        return CourseType.values()[Randomizer.generateRandomInt(0, CourseType.values().length - 1)];
    }

    public static CentreType getCentreType() {
        return CentreType.values()[Randomizer.generateRandomInt(0, CentreType.values().length - 1)];
    }

    public static boolean getBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public static int getCentreMonthlyAllowance() {
        return generateRandomInt(Settings.CENTER_ADMITTANCE_MIN.getValue(), Settings.CENTER_ADMITTANCE_MAX.getValue());
    }

    public static Centre getRandomCentre(Collection<Centre> keySet) {
        ArrayList<Centre> centres = new ArrayList<>(keySet);
        return centres.get(generateRandomInt(0, centres.size()-1));
    }

    public static CentreType getRandomCentreType(Collection<CentreType> availableCentreTypes) {
        ArrayList<CentreType> centreTypes = new ArrayList<>(availableCentreTypes);
        return centreTypes.get(generateRandomInt(0, centreTypes.size()-1));
    }
}