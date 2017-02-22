package com.redhat.brq.integration.switchyard.accounting;

import java.util.ArrayList;
import java.util.List;

import org.switchyard.annotations.Transformer;

import com.redhat.brq.integration.switchyard.inventory.InventoryRequest;
import com.redhat.brq.integration.switchyard.models.OrderItem;
import com.redhat.brq.integration.switchyard.models.OrderItemStatus;

public final class InventoryTransformer {

	@Transformer
	public String transformInventoryRequestToString(InventoryRequest inventoryRequest) {
		StringBuffer result = new StringBuffer();
		for (OrderItem item : inventoryRequest.getOrderItems()) {
			result.append(item.getArticleId() + ";" + item.getCount() + "\n");
		}
		return result.toString();
	}

	@Transformer
	public InventoryResponse transformStringToInventoryResponse(String text) {
		List<OrderItemStatus> orderItemStatuses = new ArrayList<>();
		String[] lines = text.split("\r\n");
		for (String line : lines) {
			String[] parts = line.split(";");
			orderItemStatuses.add(
					new OrderItemStatus(Long.valueOf(parts[0]), Integer.valueOf(parts[1]), Integer.valueOf(parts[2])));
		}
		InventoryResponse result = new InventoryResponse();
		result.setOrderItemStatuses(orderItemStatuses);
		return result;
	}
}
