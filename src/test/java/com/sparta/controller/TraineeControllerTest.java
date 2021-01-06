package com.sparta;

import com.sparta.controller.TraineeController;
import com.sparta.model.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

public class TraineeControllerTest {

    private static LinkedList<Trainee> trainees = new LinkedList<>();
    TraineeController traineeController = new TraineeController();

    @BeforeAll
    public static void testSetup() {
        trainees = new LinkedList<>();
        trainees.add(new Trainee());
        trainees.add(new Trainee());
        trainees.add(new Trainee());
    }

    @Test
    public void doesGenerateTraineesAddMaxNumberOfTraineesToList() {
        int size = trainees.size();
        traineeController.generateTrainees(trainees, 30);
        int expectedSize = size + 30;
        Assertions.assertEquals(expectedSize, trainees.size());
    }

    @Test
    public void doesGenerateTraineesAddMinNumberOfTraineesToList() {
        int size = trainees.size();
        traineeController.generateTrainees(trainees, 20);
        int expectedSize = size + 20;
        Assertions.assertEquals(expectedSize, trainees.size());
    }

}
