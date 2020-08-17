package com.altimetrik.ee.demo.service;

import com.altimetrik.ee.demo.entity.OrderSummary;

public interface IOrderService {
	
	public OrderSummary saveOrderSummary(OrderSummary orderSummary);
	
	public OrderSummary getOrderSummary(int orderId);

}
