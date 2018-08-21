package com.info.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.info.springboot.crud.entity.Book;
import com.info.springboot.crud.service.BookService;

/**
 * RESTCOntroller class  - All Sample REST APIs are defined here and
 * this class is refereed as starting point or landing point of APIs
 *
 * @author Raghava
 */
@RestController
@RequestMapping(value = "/app")
public class BookController {

    @Autowired
    private BookService service;

    
    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public String greet() {
        return service.greet();
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book) {
        return service.createBook(book);
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable(value = "bookId") Integer bookId) {
        return service.getBook(bookId);
    }

    @GetMapping(value = "/book")
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @RequestMapping(value = "/book", method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book book) {
        return service.updateBook(book);
    }

    @DeleteMapping(value = "/book/{bookId}")
    public void deleteBook(@PathVariable(value = "bookId") Integer bookId) {
        service.deleteBook(bookId);
    }
    
}
