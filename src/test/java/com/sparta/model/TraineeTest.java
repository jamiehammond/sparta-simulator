package com.sparta.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraineeTest {

    private Trainee trainee = new Trainee();
    private Trainee trainee1 = new Trainee();

    @Test
    void checkIfIDsAreUnique() {
        Assertions.assertNotEquals(trainee.getTraineeID(), trainee1.getTraineeID());
    }
}