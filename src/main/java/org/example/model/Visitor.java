package org.example.model;

public class Visitor extends User {
    public Visitor(String name, long userId, String email, boolean isMember, int bookLimit, int borrowedBooks, int overdueCharge, int borrowDuration, double totalOverdueCharge) {
        super(name, userId, email, isMember, bookLimit, borrowedBooks, overdueCharge, borrowDuration, totalOverdueCharge);
    }

    public Visitor(String name, long userId, String mail) {
        this.name = name;
        this.userId = userId;
        this.email = mail;
    }

    @Override
    public int getBookLimit() {
        return 3;
    }

    @Override
    public double getOverdueCharge() {
        return 8;
    }

    @Override
    public int getBorrowDuration() {
        return 7;
    }


}
