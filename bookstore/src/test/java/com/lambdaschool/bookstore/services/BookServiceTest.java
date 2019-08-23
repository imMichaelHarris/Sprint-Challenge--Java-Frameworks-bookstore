package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.BookStoreApplicationTest;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookStoreApplicationTest.class)
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Before
    void setUp() {
    }

    @After
    void tearDown() {
    }

    @Test
    void findBooks() {
        assertEquals(5, bookService.findBooks(Pageable.unpaged()).size());
    }

    @Test
    void findById() {
        assertEquals("Calling Texas Home", bookService.findById(5).getBooktitle());
    }

    @Test
    void updateBook() {
    }

    @Test
    void delete() {
        bookService.delete(5);
        assertEquals(4, bookService.findBooks(Pageable.unpaged()).size());
    }
}