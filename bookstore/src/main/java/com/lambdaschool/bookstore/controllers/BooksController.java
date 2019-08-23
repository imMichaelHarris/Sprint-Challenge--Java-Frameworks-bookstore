package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.services.BookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BooksController {
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    private BookService bookSerivce;

    @ApiOperation(value = "Returns list of all books in database with Sorting. Default returns 3 books", response = Book.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve(0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number pf records per page"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value="Sorting criteria in the format: property(asc|desc). Default sort order is ascending. Multiple sort criteria are supported")
    })
    @GetMapping(value = "", produces = {"application/json"})
    public ResponseEntity<?> listAllBooks(@PageableDefault(page = 0, size = 3) Pageable pageable) throws ResourceNotFoundException {
        List<Book> list = bookSerivce.findBooks(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
