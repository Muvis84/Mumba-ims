package com.qa.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.qa.customer.domain.*;
import com.qa.utils.Config;
import org.apache.log4j.*;
import com.qa.customer.dao.*;


public class MysqlCustomerDao implements Dao<Customer> {
public static final Logger logger = Logger.getLogger(MysqlCustomerDao.class);

 private String username = "root";
 private String password = "kayambi";
	

	public MysqlCustomerDao(String username, String password) {
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb", this.username, this.password);
		}catch(SQLException e) {
			e.printStackTrace();
		}

}
	public List<Customer> readAll() {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb", this.username, this.password);
			Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery("select * from customers");)
				
				{
			ArrayList<Customer>customers = new ArrayList<>();
			while(result.next()) {
				customers.add(customerFromResultSet(result));
			}
			return customers;
			
		}catch(SQLException e) {
			logger.debug(e.getStackTrace());
			logger.debug(e.getMessage());
		}
		return new ArrayList<>();
		
			
			
		
	}

	private Customer customerFromResultSet(ResultSet result) throws SQLException {
		
		Long customerID = result.getLong("customerID");
		String name = result.getString("Name");
		String address = result.getString("address");
		return new Customer(customerID,name,address);
	}
	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb", this.username, this.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into customers(name, address) values('" + customer.getName() + "','" + customer.getAddress()+"')");
		} catch (Exception e) {
			logger.debug(e.getStackTrace());
			logger.error(e.getMessage());
			
		} 
		return null;
		
	}

	public Customer update(Customer customer) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb",this.username,this.password);
				Statement statement = connection.createStatement();){
					statement.executeUpdate("update customers set Name ='" + customer.getName()+
							"',Address='"+customer.getAddress() +"'where customerID =" +customer.getCustomerID());
					return readCustomer(customer.getCustomerID());
				}catch(Exception e) {
					logger.debug(e.getStackTrace());
					logger.error(e.getMessage());
				}
			return null;
		}
		

	private Customer readCustomer(Long customerID) {
		try(
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb",this.username,this.password);
				
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery("SELECT FROM customers where customerID = " + customerID);){
			result.next();
			return customerFromResultSet(result);
		}catch(Exception e) {
			logger.debug(e.getStackTrace());
			logger.error(e.getMessage());
		}
		
		return null;
		
	}


	

	public void delete(Long customerID) {
		try(
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb",this.username,this.username);
				Statement statement = connection.createStatement();){
		statement.executeUpdate("delete from customers where CustomerID =" + customerID);
				
		}
		catch (Exception e) {
			logger.debug(e.getCause());
			logger.error(e.getMessage());
		}
	}
	
	
}
