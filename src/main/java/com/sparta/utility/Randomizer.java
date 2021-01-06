package com.sparta.utility;

import com.sparta.configuration.Settings;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public static int generateRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    //to be renamed "static int getNewTrainees()"
    public static int getRandomNewTraineeNumber(){
        return generateRandomInt(Settings.NEW_TRAINEE_MIN.getValue(), Settings.NEW_TRAINEE_MAX.getValue());
    }
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
