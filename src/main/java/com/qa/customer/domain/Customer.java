package com.qa.customer.domain;

public class Customer {
		private Long customerID;
		private String Name;
		private String Address;
		
		public Customer(String Name, String Address) {
			this.Name =Name;
			this.Address =Address;
		}

		public Customer(Long customerID, String Name, String Address) {
			this.customerID = customerID;
			this.Name = Name;
			this.Address = Address;
		}
		
		
		
		public Long getCustomerID() {
			return customerID;
		}

		public void setCustomerID(Long customerID) {
			this.customerID = customerID;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		public String toString() {
			return " customer id:" + customerID + " name:" + Name + " address:" + Address;
		}

	}



