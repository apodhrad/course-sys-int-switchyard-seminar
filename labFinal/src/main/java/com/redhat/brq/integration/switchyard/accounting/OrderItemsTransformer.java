package com.redhat.brq.integration.switchyard.accounting;

import java.util.List;

import org.switchyard.annotations.Transformer;

import com.redhat.brq.integration.switchyard.models.OrderItem;

public final class OrderItemsTransformer {

	@Transformer
	public String transformListToString(List<OrderItem> items) {
		StringBuffer result = new StringBuffer();
		result.append("6;2");
		return result.toString();
	}

}
