package com.info.springboot.crud.entity;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class Book {

	@QuerySqlField(index = true)
	public int id;

	public String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}
	
}
