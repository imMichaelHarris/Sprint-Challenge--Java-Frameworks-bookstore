package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    @Column(nullable = false)
    private String fname;
    @Column(nullable = false)
    private String lname;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "bookAuthors",
            joinColumns = @JoinColumn(name = "authorid"))
    @JsonIgnoreProperties("authorId")
    private List<Book> authoredbooks = new ArrayList<>();

    public Author() {
    }

    public Author(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public List<Book> getAuthoredbooks() {
        return authoredbooks;
    }

    public void setAuthoredbooks(List<Book> authoredbooks) {
        this.authoredbooks = authoredbooks;
    }
}
