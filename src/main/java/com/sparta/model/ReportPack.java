package com.sparta.model;

import com.sparta.IO.Printer;
import com.sparta.utility.TimeTracker;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * The class {@code ReportPack} is gathering the relevant data
 * from the Simulation.
 */
public class ReportPack {
    /**
     * Persists the report lines that have been generated
     */
    private final LinkedList<String> reportLines;

    /**
     * The constructor is used internally for the static object creator.
     *
     * @param company the company on which the report will be created
     */
    private ReportPack(Company company) {
        reportLines = new LinkedList<>();
        populateList(company);
    }

    /**
     * It is used to generate a report of the {@code company}
     *
     * @param company is the company you wanna create the report on
     * @return an {@code ReportPack} object
     */
    public static ReportPack generateReport(Company company) {
        return new ReportPack(company);
    }

    /**
     * Used to get the formatted report.
     *
     * @return {@code Collection<String>}
     */
    public Collection<String> getLines() {
        return reportLines;
    }

    /**
     * Gathers the information and builds the report
     *
     * @param company the company on which the report is built
     */
    private void populateList(Company company) {
        add(getHeader(TimeTracker.getYearsDifference(), TimeTracker.getMonthsDifference()));
        add(getCompanyHeader());
        add(getTotalOpenCentres(company));
        add(getCentreBreakdown(company.getOpenCentres()));
        add(getTotalFullCentres(company));
        add(getCentreBreakdown(company.getFullCentres()));
        add(getTotalClosedCentres(company));
        add(getCentreBreakdown(company.getClosedCentres()));
        add(getTotalTraineesInTraining(company));
        add(getTraineesBreakdown(company.getTraineesInTraining()));
        add(getTotalTraineesOnWaiting(company));
        add(getTraineesBreakdown(company.getTraineesOnWaiting()));
        add(getTotalClients(company));
        add(getClientsBreakdown(company.getClients()));
    }

    /**
     * Adds new line to the report
     */
    private void add(String line) {
        reportLines.add(line);
    }

    public void print(){
        for (String reportLine : reportLines) {
            Printer.print(reportLine);
        }
    }


    private static String getHeader(int years, int months) {
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
        stringBuilder.append("\n====================================================\n");
        return stringBuilder.toString();
    }

    public static String getCompanyHeader() {
        return "== COMPANY REPORT ==\n";
    }

    public static String getTotalOpenCentres(Company company) {
        return "The total number of open centres: " + company.getNumberOfOpenCentres() + "\n";
    }

    public static String getTotalFullCentres(Company company) {
        return "The total number of full centres: " + company.getNumberOfFullCentres() + "\n";
    }

    public static String getTotalClosedCentres(Company company) {
        return "The total number of closed centres: " + company.getNumberOfClosedCentres() + "\n";
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
            stringBuilder.append("\n");
            return stringBuilder.toString();
        }
        return "";
    }

    public static String getTotalTraineesInTraining(Company company) {
        return "The total number of trainees in training: " + company.getNumberOfTraineesInTraining() + "\n";
    }

    public static String getTotalTraineesOnWaiting(Company company) {
        return "The total number of trainees on the waiting list is " + company.getNumberOfTraineesOnWaiting() + "\n";
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
            stringBuilder.append("\n");
            return stringBuilder.toString();
        }
        return "";
    }

    public static String getTotalClients(Company company) {
        return "The total number of clients: " + company.getNumberOfClients() + "\n";
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
            stringBuilder.append("\n");
            return stringBuilder.toString();
        }
        return "";
    }
}
