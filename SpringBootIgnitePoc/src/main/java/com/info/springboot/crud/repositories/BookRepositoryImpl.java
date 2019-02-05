package com.info.springboot.crud.repositories;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteSpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.info.springboot.crud.entity.Book;

@Component
@Lazy
public class BookRepositoryImpl implements BookRepositoryCustom {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookRepositoryImpl.class);

	private IgniteCache<Integer, Book> bookCache;

	@Autowired
	@Lazy
	private IgniteSpringBean igniteSpringBean;

	@PostConstruct
	private final void init() {
		
	}
	
	/**
	 * @param event
	 */
	@EventListener
	public void handleContextRefresh(final ContextRefreshedEvent event) {
		bookCache = igniteSpringBean.cache("BookCache");
	}

	@PreDestroy
	private final void cleanup() {
		try {
			bookCache.close();
		} catch (Exception e) {
			LOGGER.debug("Exception on cleanup : {}", e.getLocalizedMessage());
		}
	}

	

	@Override
	public List<Book> getFabricInfoById(Integer ids) {
		return null;
	}
  
	
}
