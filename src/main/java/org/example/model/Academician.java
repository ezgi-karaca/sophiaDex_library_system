package org.example.model;

import java.util.List;

public class Academician extends User {
    private List<String> researchProjects;

    public Academician(String name, long userId, String email, boolean isMember, int bookLimit, int borrowedBooks, int overdueCharge, int borrowDuration, double totalOverdueCharge, List<String> researchProjects) {
        super(name, userId, email, isMember, bookLimit, borrowedBooks, overdueCharge, borrowDuration, totalOverdueCharge);
        this.researchProjects = researchProjects;
    }

    @Override
    public int getBookLimit() {
        return 7;
    }

    @Override
    public double getOverdueCharge() {
        return 4;
    }



    @Override
    public int getBorrowDuration() {
        return 21;
    }

    public List<String> getResearchProjects(){
        return researchProjects;
    }
    public void addResearchProject(String projectName){
        researchProjects.add(projectName);
        System.out.println(name + " has added a new research project: " + projectName);
    }
}
