package com.redhat.brq.integration.switchyard.accounting;

import java.util.List;

import com.redhat.brq.integration.switchyard.models.OrderItemStatus;

public class InventoryResponse {

	private String responseId;

	private List<OrderItemStatus> orderItemStatuses;

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public List<OrderItemStatus> getOrderItemStatuses() {
		return orderItemStatuses;
	}

	public void setOrderItemStatuses(List<OrderItemStatus> orderItemStatuses) {
		this.orderItemStatuses = orderItemStatuses;
	}

}
