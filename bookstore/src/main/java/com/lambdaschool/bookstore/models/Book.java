package com.lambdaschool.bookstore.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name =  "books")
public class Book extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long booktd;

    @Column(nullable = false)
    private String booktitle;

    private String isbn;
    private Integer copy;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "bookAuthors",
            joinColumns = @JoinColumn(name = "authorid"))
    @JsonIgnoreProperties("bookId")
    private List<Author> bookauthors = new ArrayList<>();


    public Book(String bookTitle, String isbn, int copy) {
        this.booktitle = bookTitle;
        this.isbn = isbn;
        this.copy = copy;
    }

    public Book() {
    }

    public long getBooktd() {
        return booktd;
    }

    public void setBooktd(long booktd) {
        this.booktd = booktd;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
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
