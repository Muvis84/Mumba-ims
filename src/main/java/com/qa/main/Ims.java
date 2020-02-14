package com.qa.main;

import org.apache.log4j.Logger;

import com.qa.controller.Action;
import com.qa.customer.dao.*;
import com.qa.controller.CrudController;
import com.qa.controller.CustomerController;
import com.qa.controller.ItemController;
import com.qa.services.CustomerServices;
import com.qa.services.ItemServices;
import com.qa.utils.Config;
import com.qa.utils.Utils;
import com.qa.customer.domain.*;

public class Ims {
	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	public void imsSystem() {
		LOGGER.info("What is your username: ");
		Config.username = Utils.getInput();
		LOGGER.info("What is your password");
		Config.password = Utils.getInput();
		//System.out.println("rtyu");

		LOGGER.info("Which entity would you like to use?");
		Domain.printDomains();
		
		Domain domain = Domain.getDomain();
		LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

		Action.printActions();
		Action action = Action.getAction();
		
		switch (domain) {
		case CUSTOMER:
			CustomerController customerController = new CustomerController(new CustomerServices(new MysqlCustomerDao(Config.username,Config.password)));
			doAction(customerController, action);
			break;
		case ITEM:
			ItemController itemController = new ItemController(new ItemServices(new MysqlItemDao(Config.username,Config.password))); 
			doAction(itemController, action);
			break;
		case ORDER:
//			OrderController orderController = new OrderController(new OrderServices(new MysqlOrderDao(Config.username,Config.password)));
//			doAction(orderController,action);
			break;
		case STOP:
			break;
		}
		
	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		}
	}

}
