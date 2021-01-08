package com.sparta.model;

import com.sparta.configuration.Settings;
import com.sparta.utility.Randomizer;
import com.sparta.utility.TimeTracker;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

public class Client {

    private final int clientID;
    private static int count=0;
    private final LinkedList<ClientRequirements> clientRequirements;
    private ArrayList<Trainee> hiredTrainees;
    private boolean isClientHappy;
    private CourseType courseType;

    public Client() {
        this.clientID =count;
        count++;
        clientRequirements = new LinkedList<>();
        this.courseType = Randomizer.getCourseType();
        isClientHappy = true;
    }
  
    public void addHiredTrainee(Trainee trainee)  {
        hiredTrainees.add(trainee);
    }
  
    private void checkClientHappiness() {
        for (ClientRequirements currentReq : clientRequirements) {
            if (!currentReq.isCompleted()) {
                LocalDate startDate = currentReq.getStartDate();
                LocalDate endDate = startDate.plusMonths(Settings.CLIENT_REQUIREMENT_EXPIRY_TIME.getValue());
                if (TimeTracker.getCurrentDate().isAfter(endDate)) {
                    if (currentReq.getHiredTrainees().size() < currentReq.getTraineesToHire()) {
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

    public void generateRequirements() {
        clientRequirements.add(new ClientRequirements(this.courseType));
    }

    public void checkRequirements() {
        for (ClientRequirements clientRequirement : clientRequirements) {
            if (!clientRequirement.isDueDate() && !clientRequirement.isCompleted()) {
                isClientHappy = false;
                break;
            }
        }
    }

}
