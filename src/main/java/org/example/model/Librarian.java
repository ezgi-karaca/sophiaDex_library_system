package org.example.model;

import org.example.service.BookService;
import org.example.service.UserService;

import java.time.LocalDate;

public class Librarian extends User {
    private UserService userService;
    private BookService bookService;

    public Librarian(String name, long userId, String email, boolean isMember, int bookLimit, int borrowedBooks, int overdueCharge, int borrowDuration, double totalOverdueCharge, UserService userService, BookService bookService) {
        super(name, userId, email, isMember, bookLimit, borrowedBooks, overdueCharge, borrowDuration, totalOverdueCharge);
        this.userService = userService;
        this.bookService = bookService;
    }

    public Librarian(String name, long userId, String email) {
        super(name, userId, email);
    }


    public void addBook(Book book) {
        bookService.addBook(book);
    }

    public void deleteBook(long bookId) {
        bookService.deleteBook(bookId);
    }

    public void updateBook(long bookId, String newTitle, String newAuthor, String newCategory) {
        bookService.updateBook(bookId, newTitle, newAuthor, newCategory);
    }

    public void listAllBooks() {
        bookService.listAllBooks();
    }


    public void addUser(User user) {
        userService.addUser(user);
    }

    public void listAllUsers() {
        userService.listAllUsers();
    }


    public void listOverdueBooks() {
        for (User user : userService.getUserList()) {
            for (Book book : bookService.getBookList()) {
                if (!book.isAvailable() && book.getUser().equals(user) && book.getDueDate().isBefore(LocalDate.now())) {
                    System.out.println(user.getName() + " has an overdue book: " + book.getTitle());
                }
            }
        }
    }

    public void viewUserOverdueCharges(long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            System.out.println(user.getName() + " has a total overdue charge of " + user.getTotalOverdueCharge() + " TL.");
        } else {
            System.out.println("User not found.");
        }
    }

    @Override
    public int getBookLimit() {
        return 0;
    }

    @Override
    public double getOverdueCharge() {
        return 0;
    }

    @Override
    public int getBorrowDuration() {
        return 0;
    }


    public String getName() {
        return super.getName();
    }

    public long getUserId() {
        return super.getUserId();
    }

    public String getEmail() {
        return super.getEmail();
    }
}
