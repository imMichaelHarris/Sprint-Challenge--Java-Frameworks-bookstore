package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.view.GetAuthors;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
    @Query(value = "SELECT * FROM author", nativeQuery = true)
    List<GetAuthors> findAuthors(Pageable pageable);
}
