package com.info.springboot.crud.app;

import com.info.springboot.crud.entity.Book;
import com.info.springboot.crud.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * MyFirstSpringBootApplication to start Spring boot application.
 * It will create a Sample book after starting application to test GET REST method
 *
 * @author Raghava
 */
@SpringBootApplication
@ComponentScan(value ="com" )
public class MyFirstSpringBootApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext =  SpringApplication.run(MyFirstSpringBootApplication.class, args);
        BookService appService= applicationContext.getBean("bookService",BookService.class);
        Book book = new Book(1,"Maths");
        appService.createBook(book);
		System.out.println("Started Application...");
	}

}
