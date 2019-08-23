package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.view.GetBooks;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    List<GetBooks> findBooks();

    Book findBookById(long id);

    Book updateBook(long id, Book updatedBook);
}
