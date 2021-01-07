package com.sparta.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TrainingHubTest {

    static Centre trainingHub;
    static Trainee[] trainees;

    @BeforeAll
    static void setup() {
        trainingHub = new TrainingHub();
        trainees = new Trainee[]{new Trainee(), new Trainee(), new Trainee(), new Trainee()};
    }

    @Test
    void checkIfCentreIsFull() {
        Assertions.assertFalse(trainingHub.isFull(), String.valueOf(trainingHub.isFull()));
    }

    @Test
    void checkIfIdIsAssigned() {
        int expected = 0;
        for (Trainee trainee : trainees) {
            Assertions.assertEquals(expected, trainee.getTraineeID());
            expected++;
        }
    }

    @Test
    void checkIfEachNewTraineeIncreasesTheCount() {
        Assertions.assertEquals(4, trainees[0].getCount());
    }

    @Test
    void checkIfTraineeAddedToArrayList() {
        int expected = 0;
        for (Trainee trainee : trainees) {
            if (trainee.getCourseType() == trainingHub.getCourseType()) {
                trainingHub.addTrainee(trainee);
                expected++;
            }
        }
        Assertions.assertEquals(expected, trainees[0].getCount());
    }

    @Test
    void checkifIDsAreUnique() {
        Assertions.assertNotEquals(trainingHub.getCentreId(), trainingHub.getCentreId());
    }

}
