package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Author;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {
    List<Author> findAuthors(Pageable pageable);

    List<Author> assign(long bookid, long authorid);
}
