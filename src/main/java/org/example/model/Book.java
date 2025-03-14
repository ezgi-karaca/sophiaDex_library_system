package org.example.model;

import java.time.LocalDate;

public class Book {
    private long id;
    private String title;
    private String author;
    private String category;
    private boolean isAvailable;
    private User user;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private double overdueCharge;


    public Book(long id, String title, String author, String category, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = true;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public double getOverdueCharge() {
        return overdueCharge;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
