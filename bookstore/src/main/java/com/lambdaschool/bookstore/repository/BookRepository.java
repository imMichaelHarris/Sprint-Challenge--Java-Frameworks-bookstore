package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.view.GetBooks;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    @Query(value = "SELECT * FROM book", nativeQuery = true)
    List<GetBooks> findBooks(Pageable pageable);
//
    @Query(value = "SELECT * FROM book WHERE bookid = :id", nativeQuery = true)
    Book findBookById(long id);
//
//    Book updateBook(long id, Book updatedBook);
    @Query(value = "DELETE FROM book WHERE bookid = 3", nativeQuery = true)
    void delete(long id);
}
