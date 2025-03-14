package org.example;

import org.example.model.*;
import org.example.service.BookService;
import org.example.service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BookService bookService = new BookService();
        UserService userService = new UserService(bookService);

        bookService.addBook(new Book(1, "Java Programming", "John Doe", "Programming", true));
        bookService.addBook(new Book(2, "Philosophy of Mind", "Jane Doe", "Philosophy", true));

        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your user ID: ");
        long userId = scanner.nextLong();

        scanner.nextLine();

        System.out.println("Select your user type:");
        System.out.println("1. Student");
        System.out.println("2. Academician");
        System.out.println("3. Visitor");
        System.out.println("4. Librarian");
        System.out.print("Choose an option: ");
        int userType = scanner.nextInt();
        scanner.nextLine();

        boolean isScholarshipStudent = false;
        if (userType == 1) {
            System.out.print("Are you a scholarship student? (yes/no): ");
            String scholarship = scanner.nextLine();
            isScholarshipStudent = scholarship.equalsIgnoreCase("yes");
        }

        switch (userType) {
            case 1:
                Student student = new Student(name, userId, "student@mail.com", true, 5, 0, 0, 0, 0.0, false);
                student.setScholarship(isScholarshipStudent);
                userService.addUser(student);
                break;

            case 2:
                break;

            case 3:
                Visitor visitor = new Visitor(name, userId, "visitor@mail.com");
                userService.addUser(visitor);
                break;

            case 4:
                Librarian librarian = new Librarian(name, userId, "librarian@mail.com");
                userService.addUser(librarian);
                break;

            default:
                System.out.println("Invalid user type selected.");
                return;
        }

        while (true) {
            System.out.println("\n--- Library System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Update Book");
            System.out.println("4. List All Books");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Register as Member");
            System.out.println("8. View Transaction History");
            System.out.println("9. Pay Overdue Charges");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book category: ");
                    String category = scanner.nextLine();
                    bookService.addBook(new Book(bookService.getBookList().size() + 1, title, author, category, true));
                    break;

                case 5:
                    System.out.print("Enter your user ID: ");
                    long borrowUserId = scanner.nextLong();
                    System.out.print("Enter book ID to borrow: ");
                    long borrowBookId = scanner.nextLong();
                    userService.borrowBook(borrowUserId, borrowBookId);
                    System.out.println(userService.getUserList());
                    break;

                case 6:
                    System.out.print("Enter your user ID: ");
                    long returnUserId = scanner.nextLong();
                    System.out.print("Enter book ID to return: ");
                    long returnBookId = scanner.nextLong();
                    userService.returnBook(returnUserId, returnBookId);
                    break;

                case 9:
                    System.out.print("Enter your user ID to pay overdue charges: ");
                    long userIdToPay = scanner.nextLong();
                    User userToPay = userService.getUserById(userIdToPay);
                    if (userToPay != null) {
                        double overdueCharge = userToPay.getOverdueCharge();
                        System.out.println("Your overdue charge is: " + overdueCharge + " TL");
                        System.out.print("Do you want to pay this charge? (yes/no): ");
                        String payCharge = scanner.next();
                        if (payCharge.equalsIgnoreCase("yes")) {
                            userToPay.addOverdueCharge(-overdueCharge);
                            System.out.println("Your overdue charge has been cleared.");
                        } else {
                            System.out.println("You have not paid the overdue charge.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 10:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}
