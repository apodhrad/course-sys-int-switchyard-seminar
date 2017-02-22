package com.redhat.brq.integration.switchyard.inventory;

import java.util.List;

import com.redhat.brq.integration.switchyard.models.OrderItem;

public class InventoryRequest {

	private List<OrderItem> orderItems;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
