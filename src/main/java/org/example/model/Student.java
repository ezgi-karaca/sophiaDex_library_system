package org.example.model;

public class Student extends User {
    private boolean hasScholarship;

    public Student(String name, long userId, String email, boolean isMember, int bookLimit, int borrowedBooks, int overdueCharge, int borrowDuration, double totalOverdueCharge, boolean hasScholarship) {
        super(name, userId, email, isMember, bookLimit, borrowedBooks, overdueCharge, borrowDuration, totalOverdueCharge);
        this.hasScholarship = hasScholarship;
    }

    public boolean hasScholarship() {
        return hasScholarship;
    }

    @Override
    public int getBookLimit() {
        return 5;
    }

    @Override
    public double getOverdueCharge() {
        return 0;
    }

    @Override
    public int getBorrowDuration() {
        return 14;
    }

    public void setScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }
}
