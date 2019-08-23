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


}
