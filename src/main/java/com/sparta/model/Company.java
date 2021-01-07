package com.sparta.model;

import com.sparta.configuration.Settings;
import com.sparta.utility.Randomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Company {

    private ArrayList<Centre> centres;
    private ArrayList<Centre> closedCentres;
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
        int[] monthlyAllowance = Randomizer.getCentreAllowanceArray(availableCentres.size());
//        System.err.println(Arrays.toString(monthlyAllowance));
        while (availableCentres.size() != 0 && waitingList.size() != 0) {
            int temp = Randomizer.generateRandomInt(0, availableCentres.size()-1);
            Centre currentCentre = availableCentres.get(temp);
            if (!currentCentre.isFull() && monthlyAllowance[temp] > 0) {
                addTraineeToCentre(waitingList.peek(), currentCentre);
                monthlyAllowance[temp]--;
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
        return centres.size() - centresAvailable(centres).size();
    }

    public int getNumberOfOpenCentres() {
        return centresAvailable(centres).size();
    }

    public int getNumberOfTraineesInTraining() {
        int count = 0;
        for (Centre centre : centres) {
            count += centre.getTraineesList().size();
        }
        return count;
    }

    public void checkCentresForClosing(){}
    public ArrayList<Centre> getCentresByCentreType(CentreType){}
    public ArrayList<Centre> getOpenCentresByCentreType(CentreType){}
    public ArrayList<Centre> getClosedCentresByCentreType(CentreType){}
    public ArrayList<Centre> getFullCentresByCentreType(CentreType){}
    public ArrayList<Trainee> getTraineesByCourseType(CourseType){}
}