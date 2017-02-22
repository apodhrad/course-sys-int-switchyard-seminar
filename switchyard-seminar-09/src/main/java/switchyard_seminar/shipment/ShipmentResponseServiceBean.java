package switchyard_seminar.shipment;

import javax.inject.Inject;

import org.switchyard.Context;
import org.switchyard.component.bean.Service;

@Service(ShipmentResponseService.class)
public class ShipmentResponseServiceBean implements ShipmentResponseService {

	@Inject
	private Context context;

	@Override
	public void consume(ShipmentResponse shipmentResponse) {
		String orderId = context.getPropertyValue("orderId");
		System.out.println(orderId);
	}

}
