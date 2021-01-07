package com.sparta.model;

import com.sparta.IO.Printer;
import com.sparta.utility.TimeTracker;

import java.util.Collection;
import java.util.Collections;
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
        add(Printer.getHeader(TimeTracker.getYearsDifference(), TimeTracker.getMonthsDifference()));
        add(Printer.getCompanyHeader());
        add(Printer.getTotalOpenCentres(company));
        add(Printer.getCentreBreakdown(company.getOpenCentres()));
        add(Printer.getTotalFullCentres(company));
        add(Printer.getCentreBreakdown(company.getFullCentres()));
        add(Printer.getTotalClosedCentres(company));
        add(Printer.getCentreBreakdown(company.getClosedCentres()));
        add(Printer.getTotalTraineesInTraining(company));
        add(Printer.getTraineesBreakdown(company.getTraineesInTraining()));
        add(Printer.getTotalTraineesOnWaiting(company));
        add(Printer.getTraineesBreakdown(company.getTraineesOnWaiting()));
        add(Printer.getTotalClients(company));
        add(Printer.getClientsBreakdown(company.getClients()));
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
}
