package com.redhat.brq.integration.switchyard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.bean.config.model.BeanSwitchYardScanner;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.component.test.mixins.http.HTTPMixIn;
import org.switchyard.component.test.mixins.naming.NamingMixIn;
import org.switchyard.test.BeforeDeploy;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;
import org.switchyard.transform.config.model.TransformSwitchYardScanner;

import com.redhat.brq.integration.switchyard.test.JMSUtils;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = {
	CDIMixIn.class,
	HTTPMixIn.class,
	NamingMixIn.class }, scanners = { BeanSwitchYardScanner.class, TransformSwitchYardScanner.class })
public class MyInventoryServiceTest {

	private SwitchYardTestKit testKit;
	private CDIMixIn cdiMixIn;

	private NamingMixIn namingMixIn;

	@BeforeDeploy
	public void deploy() throws Exception {
		JMSUtils.bindConnectionFactory(namingMixIn);
	}

	@ServiceOperation("MyInventoryService")
	private Invoker service;

	@Test
	public void testProccess() throws Exception {
		Object message = null;
		service.operation("proccess").sendInOnly(message);
	}

}
