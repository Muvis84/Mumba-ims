package com.qa.customer.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.customer.domain.Order;
import com.qa.utils.Config;
import org.apache.log4j.*;

public class MysqlOrderDao implements Dao<Order> {
	public static final Logger logger = Logger.getLogger(MysqlOrderDao.class);

	private String username = "root";
	private String password = "kayambi";

	public MysqlOrderDao(String username, String password) {

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb", this.username,
					this.password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Order> readAll() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb", this.username,
				this.password);
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery("select * from orders");)

		{
			ArrayList<Order> orders = new ArrayList<>();
			while (result.next()) {
				orders.add(orderFromResultSet(result));
			}
			return orders;

		} catch (SQLException e) {
			logger.debug(e.getStackTrace());
			logger.debug(e.getMessage());
		}
		return new ArrayList<>();

	}

	private Order orderFromResultSet(ResultSet result) throws SQLException {

		Long orderID = result.getLong("orderID");
		Long customerID = result.getLong("customerID");
		Date date = result.getDate("date");
		Long total = result.getLong("total");
		return new Order(orderID, customerID, date, total);
	}

	public Order create(Order order) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb", this.username,
				this.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into orders(customerID,qty,price) values('" + order.getCustomerID() + "','"
					+ order.getDate() + "','" + order.getTotal() + "')");
		} catch (Exception e) {
			logger.debug(e.getStackTrace());
			logger.error(e.getMessage());

		}
		return null;

	}

	public Order update(Order order) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb", this.username,
				this.password); Statement statement = connection.createStatement();) {
			statement.executeUpdate("update orders set customerID ='" + order.getCustomerID() + "', date ='"
					+ order.getDate() + "',total='" + order.getTotal() + "'where orderID =" + order.getOrderID());
			return readorder(order.getOrderID());
		} catch (Exception e) {
			logger.debug(e.getStackTrace());
			logger.error(e.getMessage());
		}
		return null;
	}

	private Order readorder(Long orderID) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb", this.username,
				this.password);

				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery("SELECT FROM orders where orderID = " + orderID);) {
			result.next();
			return orderFromResultSet(result);
		} catch (Exception e) {
			logger.debug(e.getStackTrace());
			logger.error(e.getMessage());
		}

		return null;

	}

	public void delete(Long orderID) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb", this.username,
				this.username); Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from orders where orderID =" + orderID);

		} catch (Exception e) {
			logger.debug(e.getCause());
			logger.error(e.getMessage());
		}
	}

}
