package com.redhat.brq.integration.switchyard.accounting;

public interface InventoryOutboxService {

	void send(String text);
}
