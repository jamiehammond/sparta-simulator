package com.sparta.model;

import com.sparta.utility.TimeTracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;


public class Client {

    private int clientID;
    private static int count=0;
    private LinkedList clientRequirements = new LinkedList();
    private ArrayList<Trainee> hiredTrainees;
    private boolean isClientHappy;

    public Client() {
        this.clientID =count;
        count++;
        this.clientRequirements = clientRequirements;
        addClientRequirements(clientRequirements);
    }

    private LinkedList addClientRequirements(LinkedList clientRequirements){
        this.clientRequirements = clientRequirements;
        clientRequirements.add(ClientRequirements.getStartDate);
        clientRequirements.add(ClientRequirements.getCourseType);
        clientRequirements.add(ClientRequirements.getTraineesToHire);
        clientRequirements.add(true);
        return clientRequirements;
    }

    public void addHiredTrainee(Trainee trainee)  {
        hiredTrainees.add(trainee);
    }

    private boolean isClientHappy(LinkedList clientRequirements) {
        this.isClientHappy = isClientHappy;
        Date startDate = new Date();
        try {
            startDate = new SimpleDateFormat("yyyy/MM/dd").parse(clientRequirements.get(0).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.add(Calendar.YEAR, 1);
        Date leaveDate = c.getTime();
        leaveDate.toString();
        ChronoLocalDate leaveDateTwo = LocalDate.parse(leaveDate.toString());

        while (TimeTracker.getCurrentDate().isBefore(leaveDateTwo)){
            isClientHappy = true;
        }
        if (hiredTrainees.size() < Integer.parseInt(clientRequirements.get(2).toString())){
            isClientHappy = false;
        }
        clientRequirements.set(3, isClientHappy);
        return isClientHappy;
    }


    public int getClientID() {
        return clientID;
    }
    public int getCount() {
        return count;
    }
    public LinkedList getClientRequirements() {return clientRequirements;}
    public ArrayList<Trainee> getHiredTrainees() {return hiredTrainees;}
    public boolean isClientHappy() {return isClientHappy;}

}
