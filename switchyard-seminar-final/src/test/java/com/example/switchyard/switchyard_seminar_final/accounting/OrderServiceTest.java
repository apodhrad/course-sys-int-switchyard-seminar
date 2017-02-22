package com.example.switchyard.switchyard_seminar_final.accounting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.component.test.mixins.http.HTTPMixIn;
import org.switchyard.component.test.mixins.naming.NamingMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

import com.example.switchyard.switchyard_seminar_final.ModelFactory;
import com.example.switchyard.switchyard_seminar_final.model.Order;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = {
	CDIMixIn.class,
	HTTPMixIn.class,
	NamingMixIn.class })
public class OrderServiceTest {

	private SwitchYardTestKit testKit;
	private CDIMixIn cdiMixIn;
	private HTTPMixIn httpMixIn;
	private NamingMixIn NamingMixIn;
	
	@ServiceOperation("OrderService")
	private Invoker service;

	@Test
	public void testSubmitOrder() throws Exception {
		Order message = ModelFactory.createOrder(1l);
		String result = service.operation("submitOrder").sendInOut(message).getContent(String.class);

		// validate the results
		Assert.assertTrue("Implement me", false);
	}

}
