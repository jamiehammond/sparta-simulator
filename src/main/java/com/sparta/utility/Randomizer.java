package com.sparta.utility;

import com.sparta.configuration.Settings;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public enum Courses
    {
        Java, C, Data, DevOps, Business
    }
    public static int generateRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static Courses generateRandomCourse(){
        return Randomizer.Courses.values()[generateRandomInt(0,Courses.values().length-1)];
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


}