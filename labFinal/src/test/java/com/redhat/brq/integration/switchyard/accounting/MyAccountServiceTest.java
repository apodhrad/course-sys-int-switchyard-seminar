package com.redhat.brq.integration.switchyard.accounting;

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

import com.redhat.brq.integration.switchyard.test.JMSUtils;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = {
	CDIMixIn.class,
	HTTPMixIn.class,
	NamingMixIn.class })
public class MyAccountServiceTest {

	private SwitchYardTestKit testKit;
	private CDIMixIn cdiMixIn;
	private HTTPMixIn httpMixIn;
	private NamingMixIn NamingMixIn;

	@ServiceOperation("MyAccountService")
	private Invoker service;

	private NamingMixIn namingMixIn;

	@BeforeDeploy
	public void deploy() throws Exception {
		JMSUtils.bindConnectionFactory(namingMixIn);
	}

	@Test
	public void testFoo() throws Exception {
		// TODO Auto-generated method stub
		// initialize your test message
		String message = null;
		service.operation("foo").sendInOnly("aaa");

		// validate the results
		Assert.assertTrue("Implement me", false);
	}

}
