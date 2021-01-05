package com.sparta.utility;

import com.sparta.configuration.Settings;

import java.time.LocalDate;

/**
 * The class {@code TimeTracker} is tracking  and managing
 * the virtual time of the current simulation.
 *
 * @author Samurah
 * @since 1.0
 */

public class TimeTracker {

    private static int monthsPassed;
    private static LocalDate startingDate;
    private static LocalDate currentDate;
    private static LocalDate endDate;

    static{
        startSimulation();
    }
    /**
     * Initializes the Time Tracker to run for
     * {@code simulationMonths} months.
     */
    protected static void startSimulation(int simulationMonths){
        monthsPassed = 0;
        startingDate = LocalDate.now();

        currentDate = startingDate;

        endDate = startingDate.plusMonths(simulationMonths);
    }

    /**
     * Initializes the Time Tracker with the configuration
     * from the {@link Settings}
     */
    public static void startSimulation(){
        int simulationMonths = Settings.SIMULATION_MONTHS.getValue();
        startSimulation(simulationMonths);
    }

    /**
     * Checks if there is any upcoming month.
     * @return true if there is at least one month left.
     */
    public static boolean hasNextMonth(){
        return currentDate.plusMonths(1).isBefore(endDate);
    }
    /**
     * Checks if there is any upcoming day.
     * @return true if there is at least one day left.
     */
    public static boolean hasNextDay(){
        return currentDate.plusDays(1).isBefore(endDate);
    }
    /**
     * Increments the simulation time with one month.
     */
    public static void nextMonth(){
        if(hasNextMonth()){
            currentDate = currentDate.plusMonths(1);
            monthsPassed++;
        }
    }
    /**
     * Gets the current counter of months passed.
     * @return how many months have passed since the start of the simulation.
     */
    public static int getMonthsPassed(){
        return monthsPassed;
    }
    /**
     * Gets the current month as a value.
     * <li>January - 1</li>
     * <li>...</li>
     * <li>December - 12</li>
     *
     * @return an integer value representing the month in a year.
     */
    public static int getMonth(){
        return currentDate.getMonthValue();
    }
    /**
     * Gets the current year of the simulation.
     * @return an integer representing the current year.
     */

    public static int getYear(){
        return currentDate.getYear();
    }

    /**
     * Get current date of the simulation.
     * @return current date as {@link LocalDate}
     */
    public static LocalDate getCurrentDate(){
        return currentDate;
    }

    /**
     * Get the starting date of the simulation.
     * @return the starting date as {@link LocalDate}
     */
    public static LocalDate getStartingDate() {
        return startingDate;
    }

    /**
     * Get the end date of the simulation.
     * @return the end date as {@link LocalDate}
     */
    public static LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Get the current date as formatted to
     * <p>
     * {@code January, 2021} for input {@link LocalDate(2020, 1, 1)}
     * @param date {@link LocalDate} to be formatted
     * @return the formatted date as {@link String}
     */
    public static String toString(LocalDate date){
        return String.format("%s, %d", getMonth(date), date.getYear());
    }

    /**
     * Get the current date as formatted to
     * <p>
     * {@code January, 2021} for input {@link LocalDate(2020, 1, 1)}
     * @param date {@link LocalDate} to be formatted
     * @return the formatted date as {@link String}
     */
    private static String getMonth(LocalDate date){
        switch (date.getMonth()){
            case JANUARY:
                return "January";
            case FEBRUARY:
                return "February";
            case MARCH:
                return "March";
            case APRIL:
                return "April";
            case MAY:
                return "May";
            case JUNE:
                return "June";
            case JULY:
                return "July";
            case AUGUST:
                return "August";
            case SEPTEMBER:
                return "September";
            case OCTOBER:
                return "October";
            case NOVEMBER:
                return "November";
            case DECEMBER:
                return "December";
        }
        return null;
    }
}
