package com.sparta.utility;

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

}