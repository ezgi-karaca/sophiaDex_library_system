package org.example.service;

import org.example.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> bookList;

    public BookService() {
        this.bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookList.add(book);
        System.out.println(book.getTitle() + " has been added to the library.");
    }

    public void deleteBook(long bookId) {
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            if (book.getId() == bookId) {
                bookList.remove(i);
                System.out.println("Kitap başarıyla silindi: " + book.getTitle());
                return;
            }
        }

        System.out.println("Kitap bulunamadı.");
    }

    public void updateBook(long id, String newTitle, String newAuthor, String newCategory) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setCategory(newCategory);
                System.out.println("The book has been updated.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void listAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : bookList) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Book> searchBooksByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public Book getBookById(long bookId) {
        for (Book book : bookList) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

}
