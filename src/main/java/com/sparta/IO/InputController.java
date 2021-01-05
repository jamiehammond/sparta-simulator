package com.sparta.IO;

import java.util.Scanner;

public class InputController {

    public static boolean yesOrNo(String decision){

        while (true){
            if (decision.equalsIgnoreCase("Y")){
                return true;
            } if (decision.equalsIgnoreCase("N")){
                return false;
            } else {
                System.out.println("Please enter Y or N");
                continue;
            }
        }
    }

    public static String yesOrNoScan(){
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.next();
        return decision;
    }


}
