package com.qa.controller;

import java.util.List;

public interface GetOrderIdController<T> {
	List<T> orderDetailsDisplay(long id);
	Long getOrderId(long custId, double price);

}
