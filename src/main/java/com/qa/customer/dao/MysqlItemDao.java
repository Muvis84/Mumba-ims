package com.qa.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.qa.utils.Config;
import org.apache.log4j.*;

import com.qa.customer.domain.Item;


public class MysqlItemDao implements Dao<Item> {
public static final Logger logger = Logger.getLogger(MysqlItemDao.class);

 private String username = "root";
 private String password = "kayambi";
	

	public MysqlItemDao(String username, String password) {
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb", this.username, this.password);
		}catch(SQLException e) {
			e.printStackTrace();
		}

}
	public List<Item> readAll() {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb", this.username, this.password);
			Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery("select * from items");)
				
				{
			ArrayList<Item>items = new ArrayList<>();
			while(result.next()) {
				items.add(itemFromResultSet(result));
			}
			return items;
			
		}catch(SQLException e) {
			logger.debug(e.getStackTrace());
			logger.debug(e.getMessage());
		}
		return new ArrayList<>();
		
			
			

	}

	private Item itemFromResultSet(ResultSet result) throws SQLException {
		
		Long itemID = result.getLong("itemID");
		String name = result.getString("name");
		Long qty = result.getLong("qty");
		Double price = result.getDouble("price");
		return new Item(itemID,name,qty,price);
	}
	public Item create(Item item) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb", this.username, this.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into items(name,qty,price) values('" + item.getName() + "','" + item.getQty()+ "','" + item.getPrice()
					+ "')");
		} catch (Exception e) {
			logger.debug(e.getStackTrace());
			logger.error(e.getMessage());
			
		} 
		return null;
		
	}

	public Item update(Item item) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb",this.username,this.password);
				Statement statement = connection.createStatement();){
					statement.executeUpdate("update items set Name ='" + item.getName()+
							"', qty ='" + item.getQty() +"',price ='" +item.getPrice() +"'where itemID =" +item.getItemID());
					return readitem(item.getItemID());
				}catch(Exception e) {
					logger.debug(e.getStackTrace());
					logger.error(e.getMessage());
				}
			return null;
		}
		

	private Item readitem(Long itemID) {
		try(
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb",this.username,this.password);
				
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery("SELECT FROM items where itemID = " + itemID);){
			result.next();
			return itemFromResultSet(result);
		}catch(Exception e) {
			logger.debug(e.getStackTrace());
			logger.error(e.getMessage());
		}
		
		return null;
		
	}


	

	public void delete(Long itemID) {
		try(
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdb",this.username,this.username);
				Statement statement = connection.createStatement();){
		statement.executeUpdate("delete from items where itemID =" + itemID);
				
		}
		catch (Exception e) {
			logger.debug(e.getCause());
			logger.error(e.getMessage());
		}
	}
	
	
}


