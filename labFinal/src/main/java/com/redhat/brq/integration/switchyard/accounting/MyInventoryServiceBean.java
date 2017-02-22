package com.redhat.brq.integration.switchyard.accounting;

import javax.inject.Inject;

import org.switchyard.Context;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.redhat.brq.integration.switchyard.inventory.InventoryRequest;
import com.redhat.brq.integration.switchyard.models.Order;
import com.redhat.brq.integration.switchyard.test.ModelFactory;

@Service(MyInventoryService.class)
public class MyInventoryServiceBean implements MyInventoryService {

	@Inject
	Context context;
	
	@Inject
	@Reference
	InventoryRequestService service;
	
	@Override
	public String proccess(Object obj) {
		Order order = ModelFactory.createOrder(3L);
		InventoryRequest inventoryRequest = new InventoryRequest();
		inventoryRequest.setOrderItems(order.getItems());
		String result = service.reserve(inventoryRequest);
		System.out.println("*** " + result + "***");
		return null;
	}

}
