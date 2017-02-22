package com.redhat.brq.integration.switchyard.accounting;

import org.switchyard.Exchange;
import org.switchyard.Message;
import org.switchyard.component.camel.common.composer.CamelBindingData;
import org.switchyard.component.common.composer.ContextMapper;
import org.switchyard.component.common.composer.MessageComposer;

public class FileBindingMessageComposer implements MessageComposer<CamelBindingData> {

	@Override
	public Message compose(CamelBindingData arg0, Exchange arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CamelBindingData decompose(Exchange arg0, CamelBindingData arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContextMapper<CamelBindingData> getContextMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageComposer<CamelBindingData> setContextMapper(ContextMapper<CamelBindingData> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
