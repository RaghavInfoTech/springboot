package com.info.springboot.crud.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * MyFirstSpringBootApplication to start Spring boot application.
 * It will create a Sample book after starting application to test GET REST method
 *
 * @author Raghava
 */
@SpringBootApplication(scanBasePackages= "com")
//@ComponentScan(value ="com" )
@EntityScan("com.info.springboot.crud.entity")
@EnableJpaRepositories("com.info.springboot.crud.dao")

public class MySpringBootApplication {

	private static Logger LOG = LoggerFactory.getLogger(MySpringBootApplication.class);
	public static void main(String[] args) {

		ApplicationContext applicationContext =  SpringApplication.run(MySpringBootApplication.class, args);
	LOG.info("****************************************************************************************");
	LOG.info("*****************************Application Stated*****************************************");
	LOG.info("****************************************************************************************");
	
	}

}
