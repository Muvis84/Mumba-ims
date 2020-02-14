package com.qa.customer.dao;

import java.util.List;

public interface Dao<T> {
	List<T> readAll();
	T create(T t);
	T  update(T t);
	void delete(Long id);
	
}
