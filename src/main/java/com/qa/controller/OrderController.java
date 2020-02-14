package com.qa.controller;


import com.qa.controller.CrudController;
import com.qa.customer.domain.Order;
import com.qa.services.CrudServices;
import com.qa.services.OrderServices;
import com.qa.utils.Utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.log4j.*;

public class OrderController implements CrudController<Order> {
	private Connection connection;


	
public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	
	private CrudServices<Order> orderService;
	
	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}
	

	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for(Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	public Order create() {
		LOGGER.info("Please enter customer ID");
		Long customerID =Long.valueOf(getInput());
		LOGGER.info("enter the date ");
		Date date = Date.valueOf(getInput());
		LOGGER.info("please enter total number of order");
		Long total =Long.getLong(getInput());
		Order order = orderService.create(new Order(customerID, date,total));
		LOGGER.info("Order created");
		
		return order;
	}

	public Order update() {
		LOGGER.info("Enter the order id you like to update");
		Long orderID = Long.valueOf(getInput());
		LOGGER.info("Please enter name");
		Long customerID = Long.valueOf(getInput());
		LOGGER.info("Insert address");
		Date date= Date.valueOf(getInput());
		LOGGER.info("Enter the price");
		Long total =Long.valueOf(getInput());
		Order order1  =orderService.update(new Order(orderID,customerID,date,total));
		LOGGER.info("Order updated");
		return order1;
		
		
		
	}

	private String getInput() {
		return Utils.getInput();
	}

	
	public Connection getConnection() {
		return connection;
	}
public void delete() {
		LOGGER.info("Please enter the id you want to delete");
		Long orderID = Long.valueOf(getInput());
		orderService.delete(orderID);
		
		
	}
}
