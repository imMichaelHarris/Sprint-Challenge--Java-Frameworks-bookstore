package com.lambdaschool.bookstore.models;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorId;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
}
