package com.altimetrik.ee.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_summary")
public class OrderSummary implements Serializable{

	private static final long serialVersionUID = 6780892602825830518L;

	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private int orderId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "restaurant_id")
	private int restaurantId;

	@Column(name = "restaurant_name")
	private String restaurantName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private List<OrderItemSummary> orderItemList;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public List<OrderItemSummary> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItemSummary> orderItemList) {
		this.orderItemList = orderItemList;
	}
}
