package com.altimetrik.ee.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_item_summary")
public class OrderItemSummary {

	@Id
	@GeneratedValue
	@Column(name = "item_summary_id")
	private int itemSummaryId;
	
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_price")
	private double itemPrice;

	@Column(name = "discount")
	private float discount;
	
	@Column(name = "order_id")
	private int orderId;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

}
