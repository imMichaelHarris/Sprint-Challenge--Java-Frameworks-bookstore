package com.lambdaschool.bookstore.models;


import javax.persistence.*;

@Entity
@Table(name =  "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;

    @Column(nullable = false)
    private String bookTitle;

    private String isbn;
    private int copy;

    public Book(String bookTitle, String isbn, int copy) {
        this.bookTitle = bookTitle;
        this.isbn = isbn;
        this.copy = copy;
    }

    public Book() {
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }
}
