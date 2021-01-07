package com.sparta.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TechCentreTest {
    static Centre techCentre;
    static Trainee[] trainees;

    @BeforeAll
    static void setup() {
        techCentre = new TechCentre();
        trainees = new Trainee[]{new Trainee(), new Trainee(), new Trainee(), new Trainee()};
    }

    @Test
    void checkIfCentreIsFull() {
        Assertions.assertFalse(techCentre.isFull(), String.valueOf(techCentre.isFull()));
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
            if (trainee.getCourseType() == techCentre.getCourseType()) {
                techCentre.addTrainee(trainee);
                expected++;
            }
        }
        Assertions.assertEquals(expected, trainees[0].getCount());
    }

    @Test
    void checkifIDsAreUnique() {
        Assertions.assertNotEquals(techCentre.getCentreId(), techCentre.getCentreId());
    }

}
