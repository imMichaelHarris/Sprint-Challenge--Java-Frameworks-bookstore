package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookrepos;

    @Override
    public List<Book> findBooks() {
        List<Book> list = new ArrayList<>();
        bookrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Book findById(long id) {
        return bookrepos.findBookById(id);
    }

    @Override
    public Book updateBook(long id, Book updatedBook) {
        Book currentBook = bookrepos.findBookById(id);
        if(updatedBook.getBooktitle() != null){
            currentBook.setBooktitle(updatedBook.getBooktitle());
        }
        if(updatedBook.getIsbn() != null){
            currentBook.setIsbn(updatedBook.getIsbn());
        }
        if(updatedBook.getCopy() != null ){
            currentBook.setCopy(updatedBook.getCopy());
        }

        return bookrepos.updateBook(id, currentBook);
    }
}
