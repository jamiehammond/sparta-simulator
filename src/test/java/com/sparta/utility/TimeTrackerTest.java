package com.sparta.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TimeTrackerTest {

    @Test
    void nextMonth() {
        TimeTracker.startSimulation(2);
        Assertions.assertTrue(TimeTracker.hasNextMonth());
        TimeTracker.nextMonth();
        Assertions.assertFalse(TimeTracker.hasNextMonth());
    }

    @Test
    void hasNextDay() {
        TimeTracker.startSimulation(1);
        Assertions.assertTrue(TimeTracker.hasNextDay());
    }

    @Test
    void getMonthsPassed() {
        TimeTracker.startSimulation(2);
        Assertions.assertEquals(0, TimeTracker.getMonthsPassed());
        TimeTracker.nextMonth();
        Assertions.assertEquals(1, TimeTracker.getMonthsPassed());
    }

    @Test
    void getCurrentDate() {
        TimeTracker.startSimulation(2);
        Assertions.assertEquals(LocalDate.now(), TimeTracker.getCurrentDate());
        TimeTracker.nextMonth();
        Assertions.assertEquals(LocalDate.now().plusMonths(1).toString(), TimeTracker.getCurrentDate().toString());
    }

    @Test
    void getStartingDate() {
        TimeTracker.startSimulation(2);
        Assertions.assertEquals(LocalDate.now().toString(),TimeTracker.getCurrentDate().toString());
    }

    @Test
    void getEndDate() {
        TimeTracker.startSimulation(2);
        Assertions.assertEquals(LocalDate.now().plusMonths(2).toString(),TimeTracker.getEndDate().toString());
    }

    @Test
    void testToString() {
        TimeTracker.startSimulation(2);
        LocalDate localDate = LocalDate.of(2020, 1,1);
        String expected = "January, 2020";
        String actual = TimeTracker.toString(localDate);
        Assertions.assertEquals(expected,actual);
    }
}