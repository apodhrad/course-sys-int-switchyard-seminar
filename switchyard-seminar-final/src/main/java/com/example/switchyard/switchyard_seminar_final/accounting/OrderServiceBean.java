package com.example.switchyard.switchyard_seminar_final.accounting;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.example.switchyard.switchyard_seminar_final.model.Order;

@Service(OrderService.class)
public class OrderServiceBean implements OrderService {

	@Inject
	@Reference
	AccountingService accountingService;
	
	@Override
	public String submitOrder(Order order) {
		AccountResponse accountResponse = accountingService.account(order);
		
		return String.valueOf(order.getId());
	}

}
