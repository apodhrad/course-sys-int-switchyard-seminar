package com.redhat.brq.integration.switchyard.accounting;

import javax.inject.Inject;

import org.switchyard.Context;
import org.switchyard.component.bean.Service;

@Service(InventoryResponseService.class)
public class InventoryResponseBean implements InventoryResponseService {

	@Inject
	private Context context;

	@Override
	public void send(InventoryResponse inventoryResponse) {
		inventoryResponse.setResponseId(context.getPropertyValue("responseId"));
		System.out.println();
	}

}
