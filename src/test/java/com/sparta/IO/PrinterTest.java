package com.sparta.IO;

import com.sparta.model.Company;
import com.sparta.utility.TimeTracker;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {
//    private final PrintStream standardOut = System.out;
//    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//
//@BeforeEach
//public void setUp(){
//    System.setOut(new PrintStream(outputStreamCaptor));
//}
//
//@Test
//    void doesGreetingStringMatchExpected(){
//    Printer.greeting();
//
//    Assertions.assertEquals("Welcome to the Sparta simulator", outputStreamCaptor.toString().trim());
//}
//
//    @Test
//    void doesDefaultSettingsMatchExpected(){
//        Printer.defaultSettings();
//        Assertions.assertEquals("The default values are: ", outputStreamCaptor.toString().trim());
//    }
//
//    @Test
//    void doesSimulationTimeMatchExpected(){
//        Printer.simulationTime();
//        Assertions.assertEquals("Enter simulation time in Months (Press enter to use default value - "+Settings.getSimulationTime, outputStreamCaptor.toString().trim());
//    }
//
//    @Test
//    void doesCentreOpeningFrequencyMatchExpected(){
//        Printer.centreOpeningFrequency();
//        Assertions.assertEquals("Enter simulation time in Months (Press enter to use default value - "+Settings.getCentreOpeningFrequency, outputStreamCaptor.toString().trim());
//    }
//
//    @Test
//    void doesCentreCapacityMatchExpected(){
//        Printer.centreCapacity();
//        Assertions.assertEquals("Enter simulation time in Months (Press enter to use default value - "+Settings.getCentreCapacity, outputStreamCaptor.toString().trim());
//    }
//
//    @Test
//    void doesNewTraineeMinMatchExpected(){
//        Printer.newTraineeMin();
//        Assertions.assertEquals("Enter simulation time in Months (Press enter to use default value - "+Settings.getTraineeMin, outputStreamCaptor.toString().trim());
//    }
//    @Test
//    void doesNewTraineeMaxMatchExpected(){
//        Printer.newTraineeMax();
//        Assertions.assertEquals("Enter simulation time in Months (Press enter to use default value - "+Settings.getTraineeMax, outputStreamCaptor.toString().trim());
//    }
//
//    @Test
//    void doesNewTraineeFrequencyMatchExpected(){
//        Printer.newTraineeFrequency();
//        Assertions.assertEquals("Enter simulation time in Months (Press enter to use default value - "+Settings.getNewTraineeFrequency, outputStreamCaptor.toString().trim());
//    }
//    @Test
//    void doesCentreAdmittanceMinMatchExpected(){
//        Printer.centreAdmittanceMin();
//        Assertions.assertEquals("Enter simulation time in Months (Press enter to use default value - "+Settings.getCentreAdmittanceMin, outputStreamCaptor.toString().trim());
//    }
//    @Test
//    void doesCentreAdmittanceMaxMatchExpected(){
//        Printer.centreAdmittanceMax();
//        Assertions.assertEquals("Enter simulation time in Months (Press enter to use default value - "+Settings.getCentreAdmittanceMax, outputStreamCaptor.toString().trim());
//    }
//    @Test
//    void doesCentreAdmittanceFrequencyMatchExpected(){
//        Printer.centreAdmittanceFrequency();
//        Assertions.assertEquals("Enter simulation time in Months (Press enter to use default value - "+Settings.getCentreAdmittanceFrequency, outputStreamCaptor.toString().trim());
//    }
//    @Test
//    void doesMonthDelayMatchExpected(){
//        Printer.monthDelay();
//        Assertions.assertEquals("Enter simulation time in Months (Press enter to use default value - "+Settings.getMonthDelay, outputStreamCaptor.toString().trim());
//    }
//
//    @Test
//    void DoesAreValuesCorrectMatchExpected(){
//        Printer.areValuesCorrect();
//        Assertions.assertEquals("Are these values correct? (Y/N) ", outputStreamCaptor.toString().trim());
//    }
//
//    @Test
//    void DoesCurrentMonthMatchExpected(){
//        Printer.currentMonth();
//        Assertions.assertEquals("Current Month: "+TimeTracker.getCurrentMonth());
//    }
//
//    @Test
//    void DoesOpenCentresMatchExpected(){
//        Printer.openCentres();
//        Assertions.assertEquals("Number of open centres: "+ Company.getOpenCentres());
//    }
//
//    @Test
//    void DoesFullCentresMatchExpected(){
//        Printer.fullCentres();
//        Assertions.assertEquals("Number of full centres: "+ Company.getFullCentres());
//    }
//    @Test
//    void DoesTraineesInTrainingMatchExpected(){
//        Printer.traineesInTraining();
//        Assertions.assertEquals("Number of trainees in training: "+ Company.getTraineesInTraining());
//    }
//    @Test
//    void DoesTraineesInWaitingListMatchExpected(){
//        Printer.traineesInWaitingList();
//        Assertions.assertEquals("Number of trainees in waiting list: "+ Company.getTraineesInWaitingList());
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    @AfterEach
//    public void tearDown(){
//    System.setOut(standardOut);
//}

}