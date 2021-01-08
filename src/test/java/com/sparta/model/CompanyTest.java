package com.sparta.model;

import org.junit.jupiter.api.Assertions;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CompanyTest {

    Company company;

    @BeforeEach
    void setup() {
        company = new Company();
    }

    @Test
    void openCentresTest() {
        company.openCentre();
        Assertions.assertEquals(1, company.getOpenCentres().size());
    }

    @Test
    void getCentresTest() {
        company.getOpenCentres().add(new Bootcamp());
        Assertions.assertEquals(1, company.getOpenCentres().size());
    }


    @Test
    void getWaitingListTest() {
        company.getOpenCentres().add(new TechCentre());
        company.getWaitingList().add(new Trainee());
        company.getWaitingList().add(new Trainee());
        company.getWaitingList().add(new Trainee());
        Assertions.assertEquals(3, company.getWaitingList().size());
    }


    @Test
    void doesAssignTraineesAddTraineesFromWaitingList() {
        company.getOpenCentres().add(new TechCentre());
        company.getOpenCentres().add(new TechCentre());
        company.getOpenCentres().add(new TechCentre());
        company.getWaitingList().add(new Trainee());
        company.getWaitingList().add(new Trainee());
        company.getWaitingList().add(new Trainee());
        company.assignTrainees();
        Assertions.assertEquals(0, company.getWaitingList().size());
    }

    @Test
    void doesAssignTraineesStopAddingTraineesWhenCentresAreFull() {
        Centre centre = new TechCentre();

        int count = 0;
        while (!centre.isFull()) {
            centre.addTrainee(new Trainee());
            count++; // for debugging
        }
        company.getOpenCentres().add(centre);
        company.getWaitingList().add(new Trainee());
        company.getWaitingList().add(new Trainee());
        company.getWaitingList().add(new Trainee());
        company.assignTrainees();
        Assertions.assertEquals(3, company.getWaitingList().size());
    }
}