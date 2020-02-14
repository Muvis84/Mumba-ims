package com.qa.controller;
import com.qa.customer.domain.Customer;
import com.qa.customer.domain.Order;
import com.qa.controller.CrudController;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.log4j.*;

public class CustomerController implements CrudController<Customer> {
	private Connection connection;


	
public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	private CrudServices<Customer> customerService;
	
	public CustomerController(CrudServices<Customer> customerService) {
		this.customerService = customerService;
	}
	
	public List<Customer> readAll() {
		List<Customer> customers = customerService.readAll();
		for(Customer customer : customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
	}

	public Customer create() {
		LOGGER.info("Please enter a first name");
		String Name = Utils.getInput();
		LOGGER.info("enter the Address");
		String Address = Utils.getInput();
		Customer customer = customerService.create(new Customer(Name,Address));
		LOGGER.info("Customer created");
		
		return customer;
	}

	public Customer update() {
		LOGGER.info("Enter the customer id you like to update");
		Long customerID = Long.valueOf(getInput());
		LOGGER.info("Please enter name");
		String name = getInput();
		LOGGER.info("Insert address");
		String address = getInput();
		Customer customer1  =customerService.update(new Customer( customerID,name,address));
		LOGGER.info("Customer updated");
		return customer1;
		
		
		
	}

	private String getInput() {
		return Utils.getInput();
	}

	
	public Connection getConnection() {
		return connection;
	}
public void delete() {
		LOGGER.info("Please enter the id you want to delete");
		Long customerID = Long.valueOf(getInput());
		customerService.delete(customerID);
		
		
	}
}
