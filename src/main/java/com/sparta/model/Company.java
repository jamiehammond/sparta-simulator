package com.sparta.model;

import com.sparta.controller.CentreFactory;
import com.sparta.utility.Randomizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Company {

    private ArrayList<Centre> openCentres;
    private ArrayList<Centre> closedCentres;
    private ArrayList<Centre> fullCentres;
    private LinkedList<Trainee> waitingList;

    public Company() {
        this.openCentres = new ArrayList<>();
        this.closedCentres = new ArrayList<>();
        this.fullCentres = new ArrayList<>();
        this.waitingList = new LinkedList<>();
    }

    public LinkedList<Trainee> getWaitingList() {
        return waitingList;
    }

    public void openCentre() {
        Centre centre = CentreFactory.getRandomCentre();
        openCentres.add(centre);
    }

    public void assignTrainees() {
        ArrayList<Centre> availableCentres = centresAvailable();
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

    private ArrayList<Centre> centresAvailable() {
        return new ArrayList<>(openCentres);
    }

    private void addTraineeToCentre(Trainee trainee, Centre currentCentre) {
        currentCentre.addTrainee(trainee);
    }

    public int getNumberOfFullCentres() {
        return fullCentres.size();
    }

    public int getNumberOfOpenCentres() {
        return openCentres.size();
    }

    public int getNumberOfTraineesInTraining() {
        int count = 0;
        for (Centre centre : openCentres) {
            count += centre.getTraineesList().size();
        }
        for (Centre centre : fullCentres) {
            count += centre.getTraineesList().size();
        }
        return count;
    }

    private Collection<Trainee> getTraineesInTraining(Collection<Centre> centres){
        Collection<Trainee> trainees = new ArrayList<>();
        for (Centre centre : centres) {
            trainees.addAll(centre.getTraineesList());
        }
        return trainees;
    }

    public Collection<Centre> getOpenCentres(){
        return openCentres;
    } // will return a Collection of Centres that are open
    public Collection<Centre> getFullCentres(){
        return fullCentres;
    } // will return a Collection of Centre that are full
    public Collection<Centre> getClosedCentres(){
        return closedCentres;
    } // will return a Collection of Centre that are closed
    public Collection<Trainee> getTraineesInTraining(){
        ArrayList<Trainee> traineesInTraining = new ArrayList<>(getTraineesInTraining(openCentres));
        traineesInTraining.addAll(getTraineesInTraining(fullCentres));
        return traineesInTraining;
    } // will return a Collection of Trainee that will contain all the trainees from all the centres
    public int getNumberOfTraineesOnWaiting(){
        return waitingList.size();
    } // will return how many trainees are currently on waiting list
    public Collection<Trainee> getTraineesOnWaiting(){
     return waitingList;
    }// will return a Collection of Trainee that will contain all trainees waiting to enter a Centre

    public void checkCentresForClosing(){
        ArrayList<Centre> centresToBeClosed = new ArrayList<>();
        for (Centre centre: openCentres) {
            if(centre.isOverGracePeriod()){
                centresToBeClosed.add(centre);
            }
        }
        closedCentres.addAll(centresToBeClosed);
        openCentres.removeAll(centresToBeClosed);
    } // will check every centre to see if it is within the grace period
    private Collection<Centre> getCentresByCentreType(CentreType centreType, Collection<Centre> centres){
        ArrayList<Centre> centresOfType = new ArrayList<>();
        for (Centre centre: centres) {
            if(centre.getClass().isInstance(centreType.getInstance())){
                centresOfType.add(centre);
            }
        }
        return centresOfType;
    }
    public Collection<Centre> getOpenCentresByCentreType(CentreType centreType){
        return getCentresByCentreType(centreType, openCentres);
    }
    public Collection<Centre> getClosedCentresByCentreType(CentreType centreType){
        return getCentresByCentreType(centreType, closedCentres);
    }
    public Collection<Centre> getFullCentresByCentreType(CentreType centreType){
        return getCentresByCentreType(centreType, fullCentres);
    }
    public Collection<Trainee> getTraineesByCourseType(CourseType courseType){
        ArrayList<Trainee> trainees = new ArrayList<>();
        for (Centre openCentre : openCentres) {
            trainees.addAll(openCentre.getTraineesByCourseType(courseType));
        }
        for(Centre fullCentre: fullCentres){
            trainees.addAll(fullCentre.getTraineesByCourseType(courseType));
        }
        return trainees;
    }
}