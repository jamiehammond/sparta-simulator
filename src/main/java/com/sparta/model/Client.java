package com.sparta.model;

import com.sparta.configuration.Settings;
import com.sparta.utility.TimeTracker;
import java.time.LocalDate;
import java.util.ArrayList;

public class Client {

    private int clientID;
    private static int count=0;
    private LinkedList<ClientRequirements> clientRequirements;
    private ArrayList<Trainee> hiredTrainees;
    private boolean isClientHappy;

    public Client() {
        this.clientID =count;
        count++;
        clientRequirements = ClientRequirements.clientRequirements();
    }
    public void addHiredTrainee(Trainee trainee)  {
        hiredTrainees.add(trainee);
    }
    private void checkClientHappiness() {
        for (ClientRequirements currentReq : clientRequirements) {
            if (currentReq.isCompleted == false) {
                LocalDate startDate = currentReq.getStartDate();
                LocalDate endDate = startDate.addYears(Settings.REQUIREMENT_EXPIRY_TIME.getValue());
                if (TimeTracker.getCurrentDate().isAfter(endDate)) {
                    if (currentReq.getHiredTrainees.size() < currentReq.getTraineesToHire()) {
                        isClientHappy = false;
                        break;
                    }
                    else {
                        currentReq.setCompleted(true);
                        isClientHappy = true;
                    }
                }
            }
        }
    }

    public int getClientID() {
        return clientID;
    }
    public int getCount() {
        return count;
    }
    public LinkedList<ClientRequirements> getClientRequirements() {return clientRequirements;}
    public ArrayList<Trainee> getHiredTrainees() {return hiredTrainees;}
    public boolean isClientHappy() {return isClientHappy;}

}
