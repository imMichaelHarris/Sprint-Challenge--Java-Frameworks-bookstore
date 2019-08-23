package com.lambdaschool.bookstore.models;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorId;

    private String firstName;
    private String lastName;
}
