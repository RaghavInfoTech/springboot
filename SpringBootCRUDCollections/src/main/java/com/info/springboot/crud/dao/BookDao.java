package com.info.springboot.crud.dao;

import com.info.springboot.crud.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO class where business logic is handled here.
 * Data is collected /saved into Simple HashMap
 *
 * @author Raghava
 */
@Component
public class BookDao {

    private static Map<Integer, Book> booksMap = new HashMap<Integer, Book>();

    public Book save(Book book) {
        booksMap.put(book.getId(), book);
        return booksMap.get(book.getId());
    }

    public Book findById(Integer id) {
        return booksMap.get(id);
    }

    public List<Book> findAll() {
        List<Book> books = new ArrayList<Book>();
        for (Map.Entry entry : booksMap.entrySet()) {
            Book book = (Book) entry.getValue();
            books.add(book);
        }
        return books;
    }

    public Book update(Book book) {

        booksMap.put(book.getId(), book);
        return booksMap.get(book.getId());
    }

    public void delete(Integer bookId) {
        booksMap.remove(bookId);
    }
}
