package com.qa.customer.domain;

public class Item {
	private Long itemID;
	private String name;
	private Long qty;
	private double price;
	
	public Item(String name,Long qty, Double price) {
		this.name = name;
		this.qty = qty;
		this.price = price;
		
		
	}

	public Item(Long itemID2, String name2, Long qty2, Double price2) {
		// TODO Auto-generated constructor stub
	}

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		return "itemID" + itemID +"name" +name + "qty" + qty +"price" + price;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime* result +((name== null)? 0 :name.hashCode());
		result = prime*result+((itemID==null)? 0:itemID.hashCode());
		result = prime*result+((qty == null)? 0:qty.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		Item other =(Item) obj;
		if(name==null) {
			if(other.name !=null)
				return false;
		}else if (!name.equals(other.name))
			return false;
		
		if(itemID== null) {
			if(other.itemID !=null)
				return false;
			
		}else if(!itemID.equals(other.itemID))
			return false;
		
		if(qty==null) {
			if(other.qty !=null)
				return false;
		}else if(!qty.equals(other.qty))
			return false;
	
		return true;
	}

}


	


	