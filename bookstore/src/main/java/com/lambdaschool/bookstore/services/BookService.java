package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> findBooks(Pageable pageable);

    Book findById(long id);

    Book updateBook(long id, Book updatedBook);

    void delete(long id);
}
