package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//
//@Entity
//@Table(name = "wrote")
public class Wrote {
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "bookAuthors",
            joinColumns = @JoinColumn(name = "authorid"))
    @JsonIgnoreProperties("bookId")
    private List<Author> bookauthors = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "bookAuthors",
            joinColumns = @JoinColumn(name = "authorid"))
    @JsonIgnoreProperties("authorId")
    private List<Book> authoredbooks = new ArrayList<>();

    public Wrote(List<Author> bookauthors, List<Book> authoredbooks) {
        this.bookauthors = bookauthors;
        this.authoredbooks = authoredbooks;
    }

    public Wrote() {
    }

    public List<Author> getBookauthors() {
        return bookauthors;
    }

    public void setBookauthors(List<Author> bookauthors) {
        this.bookauthors = bookauthors;
    }

    public List<Book> getAuthoredbooks() {
        return authoredbooks;
    }

    public void setAuthoredbooks(List<Book> authoredbooks) {
        this.authoredbooks = authoredbooks;
    }
}
