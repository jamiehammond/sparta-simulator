package com.sparta.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CentreTest {

    static Centre centre;
    static Centre centre1;
    static Trainee trainee;
    static Trainee trainee2;
    static Trainee trainee3;
    static Trainee trainee4;

    @BeforeAll
    static void setup() {
        centre = new Centre();
        centre1 = new Centre();
        trainee = new Trainee();
        trainee2 = new Trainee();
        trainee3 = new Trainee();
        trainee4 = new Trainee();
    }

    @Test
    void checkIfCentreIsFull() {
        Assertions.assertFalse(centre.isFull(), String.valueOf(centre.isFull()));
    }

    @Test
    void checkIfIdIsAssigned() {
        Assertions.assertEquals(0, trainee.getTraineeID());
        Assertions.assertEquals(1, trainee2.getTraineeID());
        Assertions.assertEquals(2, trainee3.getTraineeID());
        Assertions.assertEquals(3, trainee4.getTraineeID());
    }

    @Test
    void checkIfEachNewTraineeIncreasesTheCount() {
        Assertions.assertEquals(4, trainee.getCount());
    }

    @Test
    void checkIfTraineeAddedToArrayList() {
        centre.addTrainee(trainee);
        centre.addTrainee(trainee2);
        Assertions.assertEquals(0, trainee.getTraineeID());
        Assertions.assertEquals(4, trainee.getCount());
        Assertions.assertEquals(1, trainee2.getTraineeID());
        Assertions.assertEquals(4, trainee.getCount());
    }

    @Test
    void checkIfIDsAreUnique() {
        Assertions.assertNotEquals(centre.getCentreId(), centre1.getCentreId());
    }
}
