package com.info.springboot.crud.app;

import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.info.springboot.crud.entity.Book;
import com.info.springboot.crud.service.BookService;

/**
 * MyFirstSpringBootApplication to start Spring boot application.
 * It will create a Sample book after starting application to test GET REST method
 *
 * @author Raghava
 */
@EnableAutoConfiguration
@EnableIgniteRepositories(basePackages={"com.info.springboot.crud.repository"})
@ImportResource("classpath:ignite-client-conf.xml")
@SpringBootApplication(scanBasePackages= "com.info.springboot")
@EntityScan("com.info.springboot.crud.entity")
@EnableJpaRepositories("com.info.springboot.crud.dao")

public class MySpringBootApplication {

	private static Logger LOG = LoggerFactory.getLogger(MySpringBootApplication.class);
	public static void main(String[] args) {

		ApplicationContext applicationContext =  SpringApplication.run(MySpringBootApplication.class, args);
        BookService appService= applicationContext.getBean("bookService",BookService.class);
        Book book = new Book(1,"Maths");
        appService.createBook(book);
	LOG.info("****************************************************************************************");
	LOG.info("*****************************Application Stated*****************************************");
	LOG.info("****************************************************************************************");
	
	}

}
