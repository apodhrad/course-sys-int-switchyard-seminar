package com.redhat.brq.integration.switchyard.accounting;

import com.redhat.brq.integration.switchyard.inventory.InventoryRequest;

public interface InventoryRequestService {

	String reserve(InventoryRequest inventoryRequest);
}
