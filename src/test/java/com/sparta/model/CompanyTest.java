package com.sparta.model;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.LinkedList;


class CompanyTest {
    ArrayList<Centre> centres = new ArrayList<>();
    LinkedList<Trainee> waitingList = new LinkedList<>();
    Company company = new Company(centres, waitingList);

    @Test
    void openCentresTest() {
        Company.openCentre();
        assertEquals(1, centres.size());
    }

    @Test
    void getCentresTest() {
        centres.add(new Centre());
        centres.add(new Centre());
        waitingList.add(new Trainee());
        waitingList.add(new Trainee());
        waitingList.add(new Trainee());
        assertEquals(2, Company.getCentres().size());
    }

    @Test
    void getWaitingListTest() {
        centres.add(new Centre());
        waitingList.add(new Trainee());
        waitingList.add(new Trainee());
        waitingList.add(new Trainee());
        assertEquals(3, Company.getWaitingList().size());
    }


    @Test
    void doesAssignTraineesAddTraineesFromWaitingList() {
        ArrayList<Centre> centres = new ArrayList<>();
        LinkedList<Trainee> waitingList = new LinkedList<>();
        Company company = new Company(centres, waitingList);
        centres.add(new Centre());
        centres.add(new Centre());
        centres.add(new Centre());
        waitingList.add(new Trainee());
        waitingList.add(new Trainee());
        waitingList.add(new Trainee());
        company.assignTrainees();
        Assertions.assertEquals(0, waitingList.size());
    }

    @Test
    void doesAssignTraineesStopAddingTraineesWhenCentresAreFull() {
        centres = new ArrayList<>();
        waitingList = new LinkedList<>();
        Centre centre = new Centre();
        while (!centre.isFull()) {
            centre.addTrainee();
        }
        centres.add(centre);
        waitingList.add(new Trainee());
        waitingList.add(new Trainee());
        waitingList.add(new Trainee());
        company = new Company(centres, waitingList);
        company.assignTrainees();
        Assertions.assertEquals(3, waitingList.size());


    }
}