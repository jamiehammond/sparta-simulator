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

//     random course allocation method