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


}
