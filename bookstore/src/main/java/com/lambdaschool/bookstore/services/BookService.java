package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Book;

import java.util.List;

public interface BookService {
    List<Book> findBooks();

    Book findById(long id);

    Book updateBook(long id, Book updatedBook);
}
