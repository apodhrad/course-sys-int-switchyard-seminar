package com.redhat.brq.integration.switchyard.accounting;

import java.util.List;

import com.redhat.brq.integration.switchyard.models.OrderItem;

public interface ReserveItemsService {

	void reserve(List<OrderItem> items);
}
