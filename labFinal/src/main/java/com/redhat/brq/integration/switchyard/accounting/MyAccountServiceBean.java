package com.redhat.brq.integration.switchyard.accounting;

import javax.inject.Inject;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

import com.redhat.brq.integration.switchyard.models.Order;
import com.redhat.brq.integration.switchyard.test.ModelFactory;

@Service(MyAccountService.class)
public class MyAccountServiceBean implements MyAccountService {

	@Inject
	@Reference
	MyAccountingService service;

	@Override
	public void foo(String text) {
		Order order = ModelFactory.createOrder(2l);
		AccountResponse response = service.account(order);
		
		System.out.println(response);
	}
	
	
}
