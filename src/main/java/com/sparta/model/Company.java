package com.sparta.model;

import com.sparta.utility.Randomizer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Company {

    private ArrayList<Centre> centres;
    private LinkedList<Trainee> waitingList;

    public Company() {
        this.centres = new ArrayList<>();
        this.waitingList = new LinkedList<>();
    }

    public ArrayList<Centre> getCentres() {
        return centres;
    }

    public LinkedList<Trainee> getWaitingList() {
        return waitingList;
    }

    public void openCentre() {
        Centre centre = new Centre();
        centres.add(centre);
    }

    public void assignTrainees() {
        ArrayList<Centre> availableCentres = centresAvailable(centres);
        while (availableCentres.size() != 0 && waitingList.size() != 0) {
            int temp = Randomizer.generateRandomInt(0, availableCentres.size()-1);
            Centre currentCentre = availableCentres.get(temp);
            if (!currentCentre.isFull()) {
                addTraineeToCentre(waitingList.peek(), currentCentre);
                waitingList.poll();
            } else {
                availableCentres.remove(currentCentre);
            }
        }
    }

    private ArrayList<Centre> centresAvailable(ArrayList<Centre> centres) {
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

    public int getNumberOfFullCentres() {
        return centresAvailable(centres).size() - centres.size();
    }

    public int getNumberOfOpenCentres() {
        return centresAvailable(centres).size();
    }

    public int getNumberOfTraineesInTraining() {
        int count = 0;
        for (Centre centre : centres) {
            count += centre.getNumberOfTrainees();
        }
        return count;
    }

}