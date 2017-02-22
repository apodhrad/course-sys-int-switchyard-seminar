package switchyard_seminar.shipment;

import org.switchyard.Exchange;
import org.switchyard.component.camel.common.composer.CamelBindingData;
import org.switchyard.component.camel.common.composer.CamelMessageComposer;

public class ShipmentMessageComposer extends CamelMessageComposer {

	@Override
	public CamelBindingData decompose(Exchange exchange, CamelBindingData target) throws Exception {
		target.getMessage().setHeader("orderId", 3);
		return super.decompose(exchange, target);
	}

}
