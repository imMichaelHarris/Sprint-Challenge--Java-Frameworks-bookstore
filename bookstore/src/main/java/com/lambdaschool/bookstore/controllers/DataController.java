package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.ErrorDetail;
import com.lambdaschool.bookstore.services.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('data') or hasRole('admin')")
@RequestMapping(value = "/data")
public class DataController {
    @Autowired
    private BookService bookService;

    @ApiOperation(value = "Returns a book associated with the book id", notes = "Client must have a user role of data or admin to access this endpoint", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "book was successfully deleted"),
            @ApiResponse(code = 404, message = "Could not find book associated with that id", response = ErrorDetail.class)
    })
    @DeleteMapping(value = "/books{id}")
    public ResponseEntity deleteBook(
            @ApiParam(value = "Book Id", required = true, example = "1")
            @PathVariable long id) throws TypeMismatchException {
        bookService.delete(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
