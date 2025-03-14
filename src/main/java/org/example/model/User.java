package org.example.model;

public abstract class User {
    protected String name;
    protected long userId;
    protected String email;
    protected boolean isMember;
    protected int bookLimit;
    protected int borrowedBooks;
    protected int overdueCharge;
    protected int borrowDuration;
    protected double totalOverdueCharge;

    public User(String name, long userId, String email, boolean isMember, int bookLimit, int borrowedBooks, int overdueCharge, int borrowDuration, double totalOverdueCharge) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.isMember = isMember;
        this.borrowedBooks = 0;
        this.bookLimit = bookLimit;
        this.overdueCharge = overdueCharge;
        this.borrowDuration = borrowDuration;
        this.totalOverdueCharge = totalOverdueCharge;
    }

    protected User() {
    }

    public User(String name, long userId, String email) {
        this.name = name;
        this.userId = userId;
        this.email = email;
    }

    public abstract int getBookLimit();
    public abstract double getOverdueCharge();
    public abstract int getBorrowDuration();

    public void incrementBorrowedBooks() {
        borrowedBooks++;
    }

    public void decrementBorrowedBooks() {
        borrowedBooks--;
    }

    public boolean canBorrow() {
        return borrowedBooks < bookLimit && totalOverdueCharge == 0;
    }

    public void addOverdueCharge(double amount) {
        totalOverdueCharge += amount;
    }


    public void payOverdueCharge() {
        if (totalOverdueCharge > 0) {
            System.out.println(name + " has paid the overdue charge of " + totalOverdueCharge + " TL.");
            totalOverdueCharge = 0;
        } else {
            System.out.println(name + " has no overdue charge.");
        }
    }

    public String getName() {
        return name;
    }

    public long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public boolean isMember() {
        return isMember;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    public double getTotalOverdueCharge() {
        return totalOverdueCharge;
    }

    public void setMember(boolean isMember) {
        this.isMember = isMember;
    }
}
