package com.sparta.IO;

import java.util.Scanner;

public class InputController {

    public static String userInput(){
        return new Scanner(System.in).next();
    }

    public static boolean isUserAnsweringPositive(){
        String answer = userInput();
        if(answer.matches("^(?i)[yn]$")){
            return answer.matches("^(?i)[y]$");
        } else {
            System.out.println("Please enter Y or N");
           return isUserAnsweringPositive();
        }
    }

    public static int userInputInRange(int upper, int lower){
        System.out.println("Please enter a value between " + lower + " and " + upper);
        String answer = userInput();
       if (answer.matches("^[-]?\\d*$")){
           int integer = Integer.parseInt(answer);
           if (integer >= lower && integer <= upper){
               return integer;
           }
       }
       return userInputInRange(upper,lower);
    }



}
