package com.sparta.controller;

import com.sparta.model.Company;
import com.sparta.model.Trainee;
import java.util.LinkedList;

public class TraineeController {

    public static void generateTrainees(LinkedList<Trainee> trainees, int numberOfTrainees) {
        System.err.println(numberOfTrainees);
        while (numberOfTrainees != 0) {
            trainees.add(new Trainee());
            numberOfTrainees--;
        }
    }

}
