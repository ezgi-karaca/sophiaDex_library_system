package org.example.service;

import org.example.model.Book;
import org.example.model.User;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> userList = new ArrayList<>();
    private BookService bookService;

    public UserService(BookService bookService) {
        this.bookService = bookService;
    }

    public void addUser(User user) {
        userList.add(user);
        System.out.println(user.getName() + " has been added to the system.");
    }

    public User getUserById(long userId) {
        for (User user : userList) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }


    public void listAllUsers() {
        if (userList.isEmpty()) {
            System.out.println("No users in the system.");
        } else {
            for (User user : userList) {
                System.out.println(user.getName() + " - " + user.getUserId());
            }
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public void registerAsMember(long userId) {
        User user = getUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
        } else {
            if (user.isMember()) {
                System.out.println(user.getName() + " is already a member.");
            } else {
                user.setMember(true);
                System.out.println(user.getName() + " is now a member.");
            }
        }
    }

    public void cancelMembership(long userId) {
        User user = getUserById(userId);
        if (user != null) {
            if (user.isMember()) {
                user.setMember(false);
                System.out.println(user.getName() + "'s membership has been cancelled.");
            } else {
                System.out.println(user.getName() + " is not a member.");
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public boolean isMember(long userId) {
        User user = getUserById(userId);
        if (user != null) {
            return user.isMember();
        }
        return false;
    }




    public void borrowBook(long userId, long bookId) {
        User user = getUserById(userId);
        Book book = bookService.getBookById(bookId);

        if (user != null && book != null) {
            if (book.isAvailable() && user.canBorrow()) {

                book.setUser(user);
                book.setBorrowDate(LocalDate.now());
                book.setDueDate(LocalDate.now().plusDays(user.getBorrowDuration()));
                book.setAvailable(false);

                user.incrementBorrowedBooks();
                System.out.println(book.getTitle() + " has been borrowed by " + user.getName() + " for " + user.getBorrowDuration() + " days.");
            } else {
                System.out.println("Either the book is unavailable or the user cannot borrow more books.");
            }
        } else {
            System.out.println("Invalid user or book.");
        }
    }


    public void returnBook(long userId, long bookId) {
        User user = getUserById(userId);
        Book book = bookService.getBookById(bookId);

        if (user != null && book != null) {
            if (!book.isAvailable()) {
                long overdueDays = LocalDate.now().until(book.getDueDate(), ChronoUnit.DAYS);

                if (overdueDays > 0) {
                    double overdueCharge = overdueDays * user.getOverdueCharge();
                    user.addOverdueCharge(overdueCharge);
                    System.out.println(user.getName() + " has returned the book: " + book.getTitle());
                    System.out.println("Overdue fee for " + user.getName() + " is: " + overdueCharge + " TL.");
                } else {
                    System.out.println(user.getName() + " has returned the book: " + book.getTitle());
                    System.out.println("No overdue fee for " + user.getName());
                }


                book.setAvailable(true);
                user.decrementBorrowedBooks();
            } else {
                System.out.println(book.getTitle() + " was not borrowed.");
            }
        } else {
            System.out.println("Invalid user or book.");
        }
    }




}
