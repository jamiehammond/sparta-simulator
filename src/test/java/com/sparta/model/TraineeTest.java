package com.sparta.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraineeTest {

    private Trainee trainee = new Trainee();
    private Trainee trainee1 = new Trainee();
    private Trainee trainee2 = new Trainee();

    @Test
    void checkIfIDsAreUnique() {
        Assertions.assertNotEquals(trainee.getTraineeID(), trainee1.getTraineeID());
    }

    @Test
    void checkIfCountIsCorrect() {
        Assertions.assertEquals(3, trainee.getCount());
    }

    @Test
    void checkIfTraineeHasCourseType() {
        assertNotNull(trainee.getCourseType());
    }
}