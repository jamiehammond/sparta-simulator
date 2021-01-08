package com.sparta.model;

import com.sparta.controller.CentreFactory;
import com.sparta.utility.Randomizer;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class Company {

    private final ArrayList<Centre> openCentres;
    private final ArrayList<Centre> closedCentres;
    private final ArrayList<Centre> fullCentres;
    private final LinkedList<Trainee> waitingList;
    private final LinkedList<Trainee> traineesOnBench;
    private final ArrayList<Client> clients;

    public Company() {
        this.openCentres = new ArrayList<>();
        this.closedCentres = new ArrayList<>();
        this.fullCentres = new ArrayList<>();
        this.waitingList = new LinkedList<>();
        this.traineesOnBench = new LinkedList<>();
        this.clients = new ArrayList<>();
    }

    public LinkedList<Trainee> getTraineesOnBench() {
        return traineesOnBench;
    }

    public LinkedList<Trainee> getWaitingList() {
        return waitingList;
    }

    public void openCentre() {
        Centre centre = CentreFactory.getRandomCentre();
        openCentres.add(centre);
    }

    public void assignTrainees() {
        HashMap<Centre, Integer> centreMonthAllowance = new HashMap<>();
        for (Centre centre : openCentres) {
            centreMonthAllowance.putIfAbsent(centre, Randomizer.getCentreMonthlyAllowance());
        }
        while (centreMonthAllowance.size()>0 && waitingList.size()>0) {
            Centre randomCentre = Randomizer.getRandomCentre(centreMonthAllowance.keySet());
            if (!randomCentre.isFull() && centreMonthAllowance.get(randomCentre)>0) {
                assert waitingList.peek() != null;
                randomCentre.addTrainee(waitingList.poll());
                centreMonthAllowance.put(randomCentre,centreMonthAllowance.get(randomCentre)-1);
            } else {
                centreMonthAllowance.remove(randomCentre);
                if (randomCentre.isFull()) {
                    openCentres.remove(randomCentre);
                    fullCentres.add(randomCentre);
                }
            }
        }
    }

    public void gatherNewTrainees() {
        waitingList.addAll(Trainee.generateTrainees(Randomizer.getNewTrainees()));
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

    public int getNumberOfClosedCentres(){
        return this.closedCentres.size();
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
        System.err.println("Centres to close ="+centresToBeClosed.size());
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

    public Collection<Trainee> getTraineeOnBenchWithCourseType(CourseType courseType){
        ArrayList<Trainee> trainees = new ArrayList<>();
        for(Trainee trainee: traineesOnBench){
            if(trainee.getCourseType()==courseType) {
                trainees.add(trainee);
            }
        }
        return trainees;
    }

    public Collection<Client> getClients() {
        return clients;
    }

    public int getNumberOfClients() {
        return clients.size();
    }

    public void addClient() {
        clients.add(new Client());
    }

    public void graduateTrainees() {
        for (Centre openCentre : openCentres) {
            traineesOnBench.addAll(openCentre.getGraduates());
        }
        for (Centre fullCentre : fullCentres) {
            traineesOnBench.addAll(fullCentre.getGraduates());

        }
    }

    public void fulfillClientRequirements() {
        for (Client client : clients) {
            client.checkRequirements();
            if (client.isClientHappy()) {
                for (ClientRequirements clientRequirement : client.getClientRequirements()) {
                    if (!clientRequirement.isCompleted()) {
                        traineesOnBench.removeAll(clientRequirement.addTrainees(getTraineeOnBenchWithCourseType(clientRequirement.getCourseType())));
                    }
                }

            }
        }
    }

    public Collection<Client> getHappyClients() {
        ArrayList<Client> happyClients = new ArrayList<>();
        for (Client client : clients) {
            if (client.isClientHappy()) {
                happyClients.add(client);
            }
        }
        return happyClients;
    }

    public void checkCentresForOpening() {
        for (Centre centre : closedCentres) {
            if (!centre.isFull()) {
                markCentreAsOpen(centre);
            }
        }
    }

    private void markCentreAsFull(Centre fullCentre){
        if(openCentres.remove(fullCentre)){
            fullCentres.add(fullCentre);
        }
    }

    private void markCentreAsOpen(Centre openCentre){
        if(fullCentres.remove(openCentre)){
            openCentres.add(openCentre);
        }
    }

    private void markCentreAsClosed(Centre closedCentre){
        if(openCentres.remove(closedCentre)){
            closedCentres.add(closedCentre);
        }
    }
}