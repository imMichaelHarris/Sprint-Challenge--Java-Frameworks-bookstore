package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookrepos;

    @Override
    public List<Book> findBooks(Pageable pageable) throws ResourceNotFoundException {
        List<Book> list = new ArrayList<>();
        bookrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Book findById(long id) throws ResourceNotFoundException{
//        return null;
        return bookrepos.findBookById(id);
    }

    @Override
    public Book updateBook(long id, Book updatedBook) throws ResourceNotFoundException{
//        return  null;
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

    @Override
    public void delete(long id) {
        bookrepos.delete(id);
    }
}
