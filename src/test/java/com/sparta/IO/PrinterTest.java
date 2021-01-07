package com.sparta.IO;

import com.sparta.configuration.Settings;
import com.sparta.controller.TraineeController;
import com.sparta.model.Company;
import com.sparta.utility.TimeTracker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class PrinterTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

@BeforeEach
public void setUp(){
    System.setOut(new PrintStream(outputStreamCaptor));
}

@Test
    void doesGreetingStringMatchExpected(){
    Printer.greeting();
    Assertions.assertEquals("Welcome to the Sparta simulator", outputStreamCaptor.toString().trim());
}

    @Test
    void doesDefaultSettingsMatchExpected(){
        Printer.configuration();
        Assertions.assertEquals("The default values are: \n" +
                "Simulation time in months: " +Settings.SIMULATION_MONTHS.getValue() + "\n" +
                "Centre opening frequency: " +Settings.CENTER_OPENING_FREQUENCY.getValue() + "\n" +
                "Centre capacity: " +Settings.CENTER_CAPACITY.getValue() + "\n" +
                "Lower bound for new trainee range: " +Settings.NEW_TRAINEE_MIN.getValue() + "\n" +
                "Upper bound for new trainee range: " +Settings.CENTER_OPENING_FREQUENCY.getValue() + "\n" +
                "New trainee frequency in months: " +Settings.NEW_TRAINEE_FREQUENCY.getValue() + "\n" +
                "Lower bound for centre admittance: " +Settings.CENTER_ADMITTANCE_MIN.getValue() + "\n" +
                "Upper bound for centre admittance: " +Settings.CENTER_ADMITTANCE_MAX.getValue() + "\n" +
                "Centre admittance frequency: " +Settings.CENTER_ADMITTANCE_FREQUENCY.getValue() + "\n" +
                "Seconds per month: " +Settings.MONTH_IN_MS.getValue(), outputStreamCaptor.toString().trim());
    }

    @Test
    void doesSimulationTimeMatchExpected(){
        Printer.simulationTime();
        Assertions.assertEquals("Enter simulation time in Months (Press enter to use default value: "+ Settings.SIMULATION_MONTHS.getValue(), outputStreamCaptor.toString().trim());
    }

    @Test
    void doesCentreOpeningFrequencyMatchExpected(){
        Printer.centreOpeningFrequency();
        Assertions.assertEquals("Enter centre opening frequency (Press enter to use default value: "+ Settings.CENTER_OPENING_FREQUENCY.getValue(), outputStreamCaptor.toString().trim());
    }

    @Test
    void doesCentreCapacityMatchExpected(){
        Printer.centreCapacity();
        Assertions.assertEquals("Enter centre capacity (Press enter to use default value: "+Settings.CENTER_CAPACITY.getValue(), outputStreamCaptor.toString().trim());
    }

    @Test
    void doesNewTraineeMinMatchExpected(){
        Printer.newTraineeMin();
        Assertions.assertEquals("Enter lower bound for new trainee generation range (Press enter to use default value: "+Settings.NEW_TRAINEE_MIN.getValue(), outputStreamCaptor.toString().trim());
    }
    @Test
    void doesNewTraineeMaxMatchExpected(){
        Printer.newTraineeMax();
        Assertions.assertEquals("Enter upper bound for new trainee generation range (Press enter to use default value: "+Settings.NEW_TRAINEE_MAX.getValue(), outputStreamCaptor.toString().trim());
    }

    @Test
    void doesNewTraineeFrequencyMatchExpected(){
        Printer.newTraineeFrequency();
        Assertions.assertEquals("Enter new trainee frequency in months (Press enter to use default value: "+Settings.NEW_TRAINEE_FREQUENCY.getValue(), outputStreamCaptor.toString().trim());
    }
    @Test
    void doesCentreAdmittanceMinMatchExpected(){
        Printer.centreAdmittanceMin();
        Assertions.assertEquals("Enter lower bound for centre admittance (Press enter to use default value: "+Settings.CENTER_ADMITTANCE_MIN.getValue(), outputStreamCaptor.toString().trim());
    }
    @Test
    void doesCentreAdmittanceMaxMatchExpected(){
        Printer.centreAdmittanceMax();
        Assertions.assertEquals("Enter upper bound for centre admittance (Press enter to use default value: "+Settings.CENTER_ADMITTANCE_MAX.getValue(), outputStreamCaptor.toString().trim());
    }
    @Test
    void doesCentreAdmittanceFrequencyMatchExpected(){
        Printer.centreAdmittanceFrequency();
        Assertions.assertEquals("Enter centre admittance frequency in months (Press enter to use default value: "+Settings.CENTER_ADMITTANCE_FREQUENCY.getValue(), outputStreamCaptor.toString().trim());
    }
    @Test
    void doesMonthDelayMatchExpected(){
        Printer.monthDelay();
        Assertions.assertEquals("Enter how many seconds represent one month (Press enter to use default value: "+Settings.MONTH_IN_MS.getValue(), outputStreamCaptor.toString().trim());
    }

    @Test
    void DoesAreValuesCorrectMatchExpected(){
        Printer.areValuesCorrectToRun();
        Assertions.assertEquals("Are these values correct to run the simulation? (Y/N):", outputStreamCaptor.toString().trim());
    }

    @Test
    void DoesCurrentMonthMatchExpected(){
        Printer.currentDate();
        Assertions.assertEquals("Current Month: "+TimeTracker.toString(TimeTracker.getCurrentDate()) + " (" + (TimeTracker.getMonthsPassed() + 1) + ")", outputStreamCaptor.toString().trim());
    }

    @Test
    void DoesOpenCentresMatchExpected(){
        Company company = new Company();
        company.openCentre();
        company.openCentre();
        Printer.openCentres(company);
        Assertions.assertEquals("Number of open centres: "+ company.getOpenCentres().size(), outputStreamCaptor.toString().trim());
    }

    @Test
    void DoesFullCentresMatchExpected(){
        Company company = new Company();
        company.openCentre();
        TraineeController.generateTrainees(company.getWaitingList(), 150);
        company.assignTrainees();
        Printer.fullCentres(company);
        Assertions.assertEquals("Number of full centres: "+ company.getNumberOfFullCentres(), outputStreamCaptor.toString().trim());
    }
    @Test
    void DoesTraineesInTrainingMatchExpected(){
        Company company = new Company();
        company.openCentre();
        company.openCentre();
        TraineeController.generateTrainees(company.getWaitingList(), 150);
        company.assignTrainees();
        Printer.traineesInTraining(company);
        Assertions.assertEquals("Number of trainees in training: "+ company.getNumberOfTraineesInTraining(), outputStreamCaptor.toString().trim());
    }

    @Test
    void DoesTraineesInWaitingListMatchExpected(){
        Company company = new Company();
        TraineeController.generateTrainees(company.getWaitingList(), 2);
        Printer.traineesInWaitingList(company);
        Assertions.assertEquals("Number of trainees in waiting list: " + company.getWaitingList().size(), outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown(){
    System.setOut(standardOut);
}

}