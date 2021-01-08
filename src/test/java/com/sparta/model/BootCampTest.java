package com.sparta.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BootCampTest {
    static Centre bootCamp;
    static Trainee[] trainees;

    @BeforeAll
    static void setup() {
        bootCamp = new Bootcamp();
        trainees = new Trainee[]{new Trainee(), new Trainee(), new Trainee(), new Trainee()};
    }

    @Test
    void checkIfCentreIsFull() {
        Assertions.assertFalse(bootCamp.isFull(), String.valueOf(bootCamp.isFull()));
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
            if (trainee.getCourseType() == bootCamp.getCourseType()) {
                bootCamp.addTrainee(trainee);
                expected++;
            }
        }
        Assertions.assertEquals(expected, trainees[0].getCount());
    }

    @Test
    void checkifIDsAreUnique() {
        Assertions.assertNotEquals(bootCamp.getCentreId(), bootCamp.getCentreId());
    }

    @Test
    void checkIfCountIncrease() {
        bootCamp.addTrainee(trainees[0]);
        bootCamp.addTrainee(trainees[1]);
        Assertions.assertEquals(2, Bootcamp.getCentreCount());
    }
    
}