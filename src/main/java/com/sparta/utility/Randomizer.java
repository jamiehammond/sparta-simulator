package com.sparta.utility;

import com.sparta.configuration.Settings;
import com.sparta.model.CentreType;
import com.sparta.model.CourseType;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public static int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    //to be renamed "static int getNewTrainees()"
    public static int getNewTrainees() {
        return generateRandomInt(Settings.NEW_TRAINEE_MIN.getValue(), Settings.NEW_TRAINEE_MAX.getValue());
    }

    private static int[] getArrayInRange(int size, int lower, int higher) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = Randomizer.generateRandomInt(lower, higher);
        }
        return array;
    }

    public static int[] getCentreAllowanceArray(int size) {
        return getArrayInRange(size, Settings.CENTER_ADMITTANCE_MIN.getValue(), Settings.CENTER_ADMITTANCE_MAX.getValue());
    }

    public static CourseType getCourseType() {
        return CourseType.values()[Randomizer.generateRandomInt(0, CourseType.values().length - 1)];
    }

    public static CentreType getCentreType() {
        return CentreType.values()[Randomizer.generateRandomInt(0, CentreType.values().length - 1)];
    }
}