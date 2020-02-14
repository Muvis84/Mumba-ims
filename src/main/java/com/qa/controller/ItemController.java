package com.qa.controller;

import com.qa.controller.CrudController;
import com.qa.customer.domain.Item;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.log4j.*;

public class ItemController implements CrudController<Item> {
	private Connection connection;


	
public static final Logger LOGGER = Logger.getLogger(ItemController.class);
	
	private CrudServices<Item> itemService;
	
	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}
	
	public List<Item> readAll() {
		List<Item> items = itemService.readAll();
		for(Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	public Item create() {
		LOGGER.info("Please enter a first name");
		String name = Utils.getInput();
		LOGGER.info("enter the quantity ");
		Long qty = Long.valueOf(getInput());
		LOGGER.info("please enter the price");
		Double price = Double.valueOf(getInput());
		Item item = itemService.create(new Item( name,qty,price));
		LOGGER.info("Item created");
		
		return item;
	}

	public Item update() {
		LOGGER.info("Enter the item id you like to update");
		Long itemID = Long.valueOf(getInput());
		LOGGER.info("Please enter name");
		String name = getInput();
		LOGGER.info("Insert address");
		Long qty = Long.valueOf(getInput());
		LOGGER.info("Enter the price");
		Double price =Double.valueOf(getInput());
		Item item1  =itemService.update(new Item(itemID,name,qty,price));
		LOGGER.info("Item updated");
		return item1;
		
		
		
	}

	private String getInput() {
		return Utils.getInput();
	}

	
	public Connection getConnection() {
		return connection;
	}
public void delete() {
		LOGGER.info("Please enter the id you want to delete");
		Long itemID = Long.valueOf(getInput());
		itemService.delete(itemID);
		
		
	}
}
