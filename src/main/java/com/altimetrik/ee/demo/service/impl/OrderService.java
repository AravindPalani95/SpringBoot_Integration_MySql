package com.altimetrik.ee.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.ee.demo.entity.OrderSummary;
import com.altimetrik.ee.demo.repository.OrderRepository;
import com.altimetrik.ee.demo.service.IOrderService;

@Service
public class OrderService implements IOrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public OrderSummary saveOrderSummary(OrderSummary orderSummary) {
		return orderRepository.save(orderSummary);
	}

	@Override
	public OrderSummary getOrderSummary(int orderId) {
		Optional<OrderSummary> orderSummary =  orderRepository.findById(orderId);
		if(orderSummary.isPresent())
			return orderSummary.get();
		else
			return null;
	}

}
