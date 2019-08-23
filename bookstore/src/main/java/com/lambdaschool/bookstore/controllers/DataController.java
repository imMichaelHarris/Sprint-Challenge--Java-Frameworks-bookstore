package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.ErrorDetail;
import com.lambdaschool.bookstore.services.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@PreAuthorize("hasRole('data') or hasRole('admin')")
@RequestMapping(value = "/data")
public class DataController {
    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "Returns a book associated with the book id", notes = "Client must have a user role of data or admin to access this endpoint", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "book was successfully deleted"),
            @ApiResponse(code = 404, message = "Could not find book associated with that id", response = ErrorDetail.class)
    })
    @DeleteMapping(value = "/books{id}")
    public ResponseEntity<?> deleteBook(
            @ApiParam(value = "Book Id", required = true, example = "1")
            @PathVariable long id, HttpServletRequest request) throws TypeMismatchException {
        logger.info( request.getMethod().toUpperCase() + " "+ request.getRequestURL() + " accessed at info level");
        bookService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(value = "/books/{bookid}/authors/{authorid}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> assignBookToAuthor(@PathVariable long bookid, @PathVariable long authorid) throws ResourceNotFoundException {
        bookService.assign(bookid, authorid);
//
//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI bookURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{}").buildAndExpand(newRole.getRoleid()).toUri();
//        responseHeaders.setLocation(bookURI);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping(value = "/books/{id}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody Book updatedBook) throws ResourceNotFoundException{
        bookService.update(id, updatedBook);
        return new ResponseEntity<>(null, HttpStatus.OK);

    }
}
