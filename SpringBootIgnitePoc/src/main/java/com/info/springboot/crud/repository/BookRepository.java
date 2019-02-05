package com.info.springboot.crud.repository;


import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.springframework.context.annotation.Lazy;

import com.info.springboot.crud.entity.Book;



@Lazy
@RepositoryConfig(cacheName = "BookCache") 
public interface BookRepository extends IgniteRepository<Book, Integer> {
	
	
}