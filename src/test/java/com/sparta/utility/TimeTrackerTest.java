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
    }

    @Test
    void getStartingDate() {
    }

    @Test
    void getEndDate() {
    }

    @Test
    void testToString() {
    }
}