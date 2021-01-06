package com.sparta.model;

import org.junit.jupiter.api.Assertions;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.LinkedList;


class CompanyTest {

    Company company;

    @BeforeEach
    void setup() {
        company = new Company();
    }

    @Test
    void openCentresTest() {
        company.openCentre();
        Assertions.assertEquals(1, company.getCentres().size());
    }

    @Test
    void getCentresTest() {
        company.getCentres().add(new Centre());
        Assertions.assertEquals(1, company.getCentres().size());
    }


    @Test
    void getWaitingListTest() {
        company.getCentres().add(new Centre());
        company.getWaitingList().add(new Trainee());
        company.getWaitingList().add(new Trainee());
        company.getWaitingList().add(new Trainee());
        Assertions.assertEquals(3, company.getWaitingList().size());
    }


    @Test
    void doesAssignTraineesAddTraineesFromWaitingList() {
        company.getCentres().add(new Centre());
        company.getCentres().add(new Centre());
        company.getCentres().add(new Centre());
        company.getWaitingList().add(new Trainee());
        company.getWaitingList().add(new Trainee());
        company.getWaitingList().add(new Trainee());
        company.assignTrainees();
        Assertions.assertEquals(0, company.getWaitingList().size());
    }

    @Test
    void doesAssignTraineesStopAddingTraineesWhenCentresAreFull() {
        Centre centre = new Centre();

        int count = 0;
        while (!centre.isFull()) {
            centre.addTrainee(new Trainee());
            count++; // for debugging
        }
        company.getCentres().add(centre);
        company.getWaitingList().add(new Trainee());
        company.getWaitingList().add(new Trainee());
        company.getWaitingList().add(new Trainee());
        company.assignTrainees();
        Assertions.assertEquals(3, company.getWaitingList().size());
    }
}