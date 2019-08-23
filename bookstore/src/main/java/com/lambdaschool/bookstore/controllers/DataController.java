package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/data")
public class DataController {
    @Autowired
    private BookService bookService;

    @DeleteMapping(value = "/books{id}")
    public ResponseEntity deleteBook(@PathVariable long id){
        bookService.delete(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
