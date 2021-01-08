package com.sparta.model;

import com.sparta.utility.Randomizer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Client {

    private static int count = 0;
    private final int clientID;
    private final LinkedList<ClientRequirements> clientRequirements;
    private final CourseType courseType;
    private ArrayList<Trainee> hiredTrainees;
    private boolean isClientHappy;

    public Client() {
        this.clientID = count;
        count++;
        isClientHappy = true;
        clientRequirements = new LinkedList<>();
        this.courseType = Randomizer.getCourseType();
        this.hiredTrainees = new ArrayList<>();
        generateRequirements();
    }

    private void checkClientHappiness() {
        for (ClientRequirements currentReq : clientRequirements) {
            currentReq.checkIfComplete();
            if (!currentReq.isCompleted()) {
                if (!currentReq.isDueDate()) {
                    if (!currentReq.isCompleted()) {
                        isClientHappy = false;
                        break;
                    }
                }
            }
            hiredTrainees.addAll(currentReq.getHiredTrainees());
        }
    }

        public int getClientID () {
            return clientID;
        }
        public int getCount () {
            return count;
        }
        public LinkedList<ClientRequirements> getClientRequirements () {
            return clientRequirements;
        }
        public ArrayList<Trainee> getHiredTrainees () {
            return hiredTrainees;
        }
        public boolean isClientHappy () {
            return isClientHappy;
        }

        public void generateRequirements () {
            clientRequirements.add(new ClientRequirements(this.courseType));
        }

        public void checkRequirements () {
            checkClientHappiness();
        }

    }
