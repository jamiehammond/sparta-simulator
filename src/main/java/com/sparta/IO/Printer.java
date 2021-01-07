package com.sparta.IO;

import com.sparta.configuration.Settings;
import com.sparta.model.*;
import com.sparta.utility.TimeTracker;

import java.util.Collection;
import java.util.HashMap;

public class Printer {

    public static void print(String message) {
        System.out.println(message);
    }

    public static void greeting() {
          print("====================================================\n" +
                "         Welcome to the Sparta simulator\n" +
                "====================================================\n");
    }

    public static void configuration() {
        print("The default values are: \n" +
                "Simulation time in months: " + Settings.SIMULATION_MONTHS.getValue() + "\n" +
                "Centre opening frequency: " + Settings.CENTER_OPENING_FREQUENCY.getValue() + "\n" +
                "Lower bound for new trainee range: " + Settings.NEW_TRAINEE_MIN.getValue() + "\n" +
                "Upper bound for new trainee range: " + Settings.CENTER_OPENING_FREQUENCY.getValue() + "\n" +
                "New trainee frequency in months: " + Settings.NEW_TRAINEE_FREQUENCY.getValue() + "\n" +
                "Lower bound for centre admittance: " + Settings.CENTER_ADMITTANCE_MIN.getValue() + "\n" +
                "Upper bound for centre admittance: " + Settings.CENTER_ADMITTANCE_MAX.getValue() + "\n" +
                "Centre admittance frequency: " + Settings.CENTER_ADMITTANCE_FREQUENCY.getValue() + "\n" +
                "Seconds per month: " + Settings.MONTH_IN_MS.getValue());
    }

    public static void simulationTime() {
        print("Enter simulation time in Months (Press enter to use default value: " + Settings.SIMULATION_MONTHS.getValue());
    }

    public static void centreOpeningFrequency() {
        print("Enter centre opening frequency (Press enter to use default value: " + Settings.CENTER_OPENING_FREQUENCY.getValue());
    }

    public static void centreCapacity(Centre centre) {
        print("Enter centre capacity (Press enter to use default value: " + centre.getCapacity());
    }

    public static void newTraineeMin() {
        print("Enter lower bound for new trainee generation range (Press enter to use default value: " + Settings.NEW_TRAINEE_MIN.getValue());
    }

    public static void newTraineeMax() {
        print("Enter upper bound for new trainee generation range (Press enter to use default value: " + Settings.NEW_TRAINEE_MAX.getValue());
    }

    public static void newTraineeFrequency() {
        print("Enter new trainee frequency in months (Press enter to use default value: " + Settings.NEW_TRAINEE_FREQUENCY.getValue());
    }

    public static void centreAdmittanceMin() {
        print("Enter lower bound for centre admittance (Press enter to use default value: " + Settings.CENTER_ADMITTANCE_MIN.getValue());
    }

    public static void centreAdmittanceMax() {
        print("Enter upper bound for centre admittance (Press enter to use default value: " + Settings.CENTER_ADMITTANCE_MAX.getValue());
    }

    public static void centreAdmittanceFrequency() {
        print("Enter centre admittance frequency in months (Press enter to use default value: " + Settings.CENTER_ADMITTANCE_FREQUENCY.getValue());
    }

    public static void monthDelay() {
        print("Enter how many seconds represent one month (Press enter to use default value: " + Settings.MONTH_IN_MS.getValue());
    }

    public static void areValuesCorrectToRun() {
        print("Are these values correct to run the simulation? (Y/N):");
    }

    public static void currentDate() {
        print("Current date: " + TimeTracker.toString(TimeTracker.getCurrentDate()) + " (" + TimeTracker.getMonthsPassed() + ")");
    }

    public static void printProgress(Company company) {
        currentDate();
        openCentres(company);
        fullCentres(company);
        traineesInTraining(company);
        traineesInWaitingList(company);
        print("");
    }

    public static void openCentres(Company company) {
        print("Number of open centres: " + company.getNumberOfOpenCentres());
    }

    public static void fullCentres(Company company) {
        print("Number of full centres: " + company.getNumberOfFullCentres());
    }

    public static void traineesInTraining(Company company) {
        print("Number of trainees in training: " + company.getNumberOfTraineesInTraining());
    }

    public static void traineesInWaitingList(Company company) {
        print("Number of trainees in waiting list: " + company.getWaitingList().size());
    }

    public static String getHeader(int years, int months) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("====================================================\n");
        stringBuilder.append("The Simulation ran for ");

        if (years > 0) {
            stringBuilder.append(years).append(" year");
            if (years > 1) {
                stringBuilder.append("s");
            }
        }
        if (months > 0 && years > 0) {
            stringBuilder.append(" and ");
        }
        if (months > 0) {
            stringBuilder.append(months).append(" month");
            if (months > 1) {
                stringBuilder.append("s");
            }
        }
        stringBuilder.append("\n====================================================");
        return stringBuilder.toString();
    }

    public static String getCompanyHeader() {
        return "== COMPANY REPORT ==";
    }

    public static String getTotalOpenCentres(Company company) {
        return "The total number of open centres: " + company.getNumberOfOpenCentres();
    }

    public static String getTotalFullCentres(Company company) {
        return "The total number of full centres: " + company.getNumberOfFullCentres();
    }

    public static String getTotalClosedCentres(Company company) {
        return "The total number of closed centres: " + company.getNumberOfClosedCentres();
    }

    public static String getCentreBreakdown(Collection<Centre> centres) {
        if (centres.size() > 0) {
            HashMap<CentreType, Integer> breakdown = new HashMap<>();
            for (Centre centre : centres) {
                CentreType centreType = CentreType.getCentreType(centre);
                breakdown.put(centreType, breakdown.getOrDefault(centreType, 0) + 1);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("From which: ");
            for (CentreType centreType : breakdown.keySet()) {
                stringBuilder.append("\n")
                        .append(centreType.getCentreName())
                        .append(":")
                        .append(breakdown.get(centreType));
            }
            return stringBuilder.toString();
        }
        return "";
    }

    public static String getTotalTraineesInTraining(Company company) {
        return "The total number of trainees in training: " + company.getNumberOfTraineesInTraining();
    }

    public static String getTotalTraineesOnWaiting(Company company) {
        return "The total number of trainees on the waiting list is " + company.getNumberOfTraineesOnWaiting();
    }

    public static String getTraineesBreakdown(Collection<Trainee> trainees) {
        if (trainees.size() > 0) {
            HashMap<CourseType, Integer> breakdown = new HashMap<>();
            for (Trainee trainee : trainees) {
                CourseType courseType = trainee.getCourseType();
                breakdown.put(courseType, breakdown.getOrDefault(courseType, 0) + 1);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("From which: ");
            for (CourseType courseType : breakdown.keySet()) {
                stringBuilder.append("\n")
                        .append(courseType.getCourseName())
                        .append(":")
                        .append(breakdown.get(courseType));
            }
            return stringBuilder.toString();
        }
        return "";
    }

    public static String getTotalClients(Company company) {
        return "The total number of clients: " + company.getNumberOfClients();
    }

    public static String getClientsBreakdown(Collection<Client> clients) {
        if (clients.size() > 0) {
            HashMap<Boolean, Integer> breakdown = new HashMap<>();
            for (Client client : clients) {
                boolean clientStatus = client.isClientHappy();
                breakdown.put(clientStatus, breakdown.getOrDefault(clientStatus, 0) + 1);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("From which: ");
            for (boolean isHappy : breakdown.keySet()) {
                stringBuilder.append("\n");
                if (isHappy) {
                    stringBuilder.append("Happy:");
                } else {
                    stringBuilder.append("Unhappy:");
                }
                stringBuilder.append(breakdown.get(isHappy));
            }
            return stringBuilder.toString();
        }
        return "";
    }
}