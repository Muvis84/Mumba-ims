package com.qa.customer.dao;

import java.util.List;

import com.qa.customer.domain.Item;
import com.qa.customer.domain.Order;

public interface OrderDao<I,O,C>{


	List<I> readAll();
	void create(Order order);
	void update(long orderID, I i);
	void delete(long i);
	List<I> displayItems(long id);
	Double  Price(I i);
	Long getCustomerID(C c);
	List<I> displayOrders(long i);
	long getItemID(Item i);
	
}
