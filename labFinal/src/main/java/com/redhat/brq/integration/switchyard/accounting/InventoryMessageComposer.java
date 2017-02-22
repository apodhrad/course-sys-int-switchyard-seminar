package com.redhat.brq.integration.switchyard.accounting;

import org.switchyard.Exchange;
import org.switchyard.Message;
import org.switchyard.component.camel.common.composer.CamelBindingData;
import org.switchyard.component.camel.common.composer.CamelMessageComposer;

public class InventoryMessageComposer extends CamelMessageComposer {

	@Override
	public CamelBindingData decompose(Exchange exchange, CamelBindingData target) throws Exception {
		CamelBindingData data = super.decompose(exchange, target);
		String fileName = data.getMessage().getMessageId();// + ".csvx";
		data.getMessage().setHeader(org.apache.camel.Exchange.FILE_NAME, fileName);
		data.getMessage().getExchange().getOut().setBody(fileName);
		return data;
	}

	@Override
	public Message compose(CamelBindingData source, Exchange exchange) throws Exception {
		Message message = super.compose(source, exchange);
		String responseId = source.getMessage().getHeader(org.apache.camel.Exchange.FILE_NAME_ONLY, String.class);
		message.getContext().setProperty("responseId", responseId);
		return message;
	}
}
