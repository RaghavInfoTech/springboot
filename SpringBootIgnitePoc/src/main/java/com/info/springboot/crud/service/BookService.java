package com.info.springboot.crud.service;

import java.util.List;

import org.apache.ignite.IgniteSpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.info.springboot.crud.entity.Book;
import com.info.springboot.crud.repositories.BookRepository;

/**
 * Service class , provides  service to all REST APIs and calls DAO layer
 *
 * @author Raghava
 */
@Service
public class BookService {


    @SuppressWarnings("unused")
	@Autowired
    private IgniteSpringBean igniteSpringBean;
    @Autowired
    @Lazy
    private BookRepository bookCache;

    public String greet() {
        return "Hello";
    }

    public Book createBook(Book book) {
    	Book save = bookCache.save(book.getId(), book);
        return save;
    }


    public Book getBook(Integer id) {
        return bookCache.findOne(id);
    }
    public List<Book> getAllBooks(){
        return (List<Book>) bookCache.findAll();
    }

    public Book updateBook(Book book) {
        return bookCache.save(book.getId(), book);
    }

    public void deleteBook(Integer bookId) {
    	bookCache.delete(bookId);
    }
}
