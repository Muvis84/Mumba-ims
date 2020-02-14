package com.qa.customer.domain;

import java.sql.Date;

public class Order {
	private Long orderID;
	private Long customerID;
	private Date date;
	private Long total;
	
	public Order(Long customerID,Date date, Long total) {
		this.customerID= customerID;
		this.date = date;
		this.total = total;
		
		
	}

	public Order(Long orderID2, Long customerID2, Date date2, Long total2) {
		// TODO Auto-generated constructor stub
	}

	public Long getOrderID() {
		return orderID;
	}



	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}



	public Long getCustomerID() {
		return customerID;
	}



	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Long getTotal() {
		return total;
	}



	public void setTotal(Long total) {
		this.total = total;
	}



	public String toString() {
		return "orderID" + orderID +"customerID" +"" + customerID + "date" + date +"total" + total;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime*result+((orderID==null)? 0:orderID.hashCode());
		result = prime* result +((customerID== null)? 0 :customerID.hashCode());
		result = prime*result+((date == null)? 0:date.hashCode());
		result = prime* result +((total== null)? 0 :total.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		Order other =(Order) obj;
		if(orderID==null) {
			if(other.orderID !=null)
				return false;
		}else if (!orderID.equals(other.orderID))
			return false;
		
		if(customerID== null) {
			if(other.customerID !=null)
				return false;
			
		}else if(!customerID.equals(other.customerID))
			return false;
		
		if(date==null) {
			if(other.date !=null)
				return false;
		}else if(!date.equals(other.date))
			return false;
		
		if(total==null) {
			if(other.total !=null)
				return false;
			
		}else if(!total.equals(other.total)) {
			return false;
		
		}
		return false;
		
	}
}

