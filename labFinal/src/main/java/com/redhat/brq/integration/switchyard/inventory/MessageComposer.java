package com.redhat.brq.integration.switchyard.inventory;

import org.apache.commons.io.FilenameUtils;
import org.switchyard.Exchange;
import org.switchyard.Message;
import org.switchyard.Scope;
import org.switchyard.component.camel.common.composer.CamelBindingData;
import org.switchyard.component.camel.common.composer.CamelMessageComposer;

public class MessageComposer extends CamelMessageComposer {

    @Override
    public CamelBindingData decompose(Exchange exchange, CamelBindingData target) throws Exception {
        String fileName = exchange.getContext().getPropertyValue("orderId") + ".csv";
        target.getMessage().setHeader(org.apache.camel.Exchange.FILE_NAME, "blabla.txt");
        exchange.getContext().setProperty(org.apache.camel.Exchange.FILE_NAME, fileName, Scope.MESSAGE);
        return super.decompose(exchange, target);
    }

    @Override
    public Message compose(CamelBindingData source, Exchange exchange) throws Exception {
        Message msg = super.compose(source, exchange);
        String fileName = source.getMessage().getHeader(org.apache.camel.Exchange.FILE_NAME_ONLY, String.class);
        msg.getContext().setProperty("orderId", FilenameUtils.removeExtension(fileName));
        return msg;
    }
}
