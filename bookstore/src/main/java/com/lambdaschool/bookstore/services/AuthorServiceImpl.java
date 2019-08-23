package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorRepository authorrepos;

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public List<Author> assign(long bookid, long authorid) {
        return null;
    }
}
