package com.lambdaschool.bookstore.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name =  "book")
public class Book extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @Column(nullable = false)
    private String title;

    private String isbn;
    private Integer copy;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "bookAuthors",
            joinColumns = @JoinColumn(name = "bookid"))
    @JsonIgnoreProperties("book")
    private List<Author> bookauthors = new ArrayList<>();


    public Book(String bookTitle, String isbn, int copy) {
        this.title = bookTitle;
        this.isbn = isbn;
        this.copy = copy;
    }

    public Book() {
    }

    public long getBooktd() {
        return bookid;
    }

    public void setBooktd(long booktd) {
        this.bookid = booktd;
    }

    public String getBooktitle() {
        return title;
    }

    public void setBooktitle(String booktitle) {
        this.title = booktitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public List<Author> getBookauthors() {
        return bookauthors;
    }

    public void setBookauthors(List<Author> bookauthors) {
        this.bookauthors = bookauthors;
    }
}
