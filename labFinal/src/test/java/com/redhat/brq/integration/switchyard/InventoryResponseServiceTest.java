package com.redhat.brq.integration.switchyard;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.component.test.mixins.http.HTTPMixIn;
import org.switchyard.component.test.mixins.naming.NamingMixIn;
import org.switchyard.test.BeforeDeploy;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

import com.redhat.brq.integration.switchyard.accounting.InventoryResponse;
import com.redhat.brq.integration.switchyard.test.JMSUtils;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = {
	CDIMixIn.class,
	HTTPMixIn.class,
	NamingMixIn.class })
public class InventoryResponseServiceTest {

	private SwitchYardTestKit testKit;
	private CDIMixIn cdiMixIn;
	private HTTPMixIn httpMixIn;
	private NamingMixIn NamingMixIn;
	
	@ServiceOperation("InventoryOutboxService")
	private Invoker service;

	private NamingMixIn namingMixIn;

	@BeforeDeploy
	public void deploy() throws Exception {
		JMSUtils.bindConnectionFactory(namingMixIn);
	}
	@Test
	public void testSend() throws Exception {
		service.operation("send").sendInOnly("1;1;2\r\n1;1;1");

		// validate the results
		Assert.assertTrue("Implement me", false);
	}

}
