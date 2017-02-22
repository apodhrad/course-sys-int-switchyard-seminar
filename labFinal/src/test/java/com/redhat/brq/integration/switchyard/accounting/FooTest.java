package com.redhat.brq.integration.switchyard.accounting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.component.test.mixins.http.HTTPMixIn;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;
import org.switchyard.test.SwitchYardTestKit;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(config = SwitchYardTestCaseConfig.SWITCHYARD_XML, mixins = {
	CDIMixIn.class,
	HTTPMixIn.class })
public class FooTest {

	private SwitchYardTestKit testKit;
	private CDIMixIn cdiMixIn;
	private HTTPMixIn httpMixIn;
	@ServiceOperation("Foo")
	private Invoker service;

	@Test
	public void testFoo() throws Exception {
		Object message = "aaa";
		String result = service.operation("foo").sendInOut(message).getContent(String.class);

		// validate the results
		Assert.assertTrue(result != null);
	}

}
