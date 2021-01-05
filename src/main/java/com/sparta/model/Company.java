package com.sparta.model;

import com.sparta.utility.Randomizer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Company {

    private static ArrayList<Centre> centres;
    private static LinkedList<Trainee> waitingList;

    public Company(ArrayList<Centre> centres, LinkedList<Trainee> waitingList ) {
        this.centres =centres;
        this.waitingList = waitingList;
    }

    public static ArrayList<Centre> getCentres() {
        return centres;
    }

    public static LinkedList<Trainee> getWaitingList() {
        return waitingList;
    }

    public static void openCentre() {
        Centre centre = new Centre();
        centres.add(centre);
    }

    public void assignTrainees() {
        ArrayList<Centre> availableCenters = centersAvailable(centres);
        int traineeToBeAdded = 0;
        while (availableCenters.size() != 0 && waitingList.size() != 0) {
            Trainee trainee = waitingList.get(traineeToBeAdded);
            int temp = Randomizer.generateRandomInt(0, availableCenters.size());
            Centre currentCentre = availableCenters.get(temp);
            if (!currentCentre.isFull()) {
                addTraineeToCentre(trainee, currentCentre);
                removeTraineeFromWaitingList(trainee);
                traineeToBeAdded++;
            } else {
                availableCenters.remove(currentCentre);
            }
        }
    }
    private ArrayList<Centre> centersAvailable(ArrayList<Centre> centres) {
        ArrayList<Centre> centresAvailable = new ArrayList<>();
        for (Centre centre : centres) {
            if (!centre.isFull()) {
                centresAvailable.add(centre);
            }
        }
        return centresAvailable;
    }
    private void addTraineeToCentre(Trainee trainee, Centre currentCentre) {
        currentCentre.addTrainee(trainee);
    }
    private void removeTraineeFromWaitingList(Trainee trainee) {
        waitingList.remove(trainee);
    }
}
