package com.qa.controller;

import java.util.List;

import com.qa.customer.domain.Customer;
import com.qa.customer.domain.Order;

public interface CrudController<T> {
	List<T> readAll();
	T create();
	T update();
	void delete();
}
