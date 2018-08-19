package com.info.springboot.crud.service;

import com.info.springboot.crud.dao.BookDao;
import com.info.springboot.crud.dao.TicketDao;
import com.info.springboot.crud.entity.Book;
import com.info.springboot.crud.entity.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class , provides  service to all REST APIs and calls DAO layer
 *
 * @author Raghava
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private TicketDao repo;

    public String greet() {
        return "Hello";
    }

    public Book createBook(Book book) {
        return bookDao.save(book);
    }


    public Book getBook(Integer id) {
        return bookDao.findById(id);
    }
    public List<Book> getAllBooks(){
        return bookDao.findAll();
    }

    public Book updateBook(Book book) {
        return bookDao.update(book);
    }

    public void deleteBook(Integer bookId) {
        bookDao.delete(bookId);
    }
    public Ticket bookTicket(Ticket ticket) {
		return repo.save(ticket);
	}
}
