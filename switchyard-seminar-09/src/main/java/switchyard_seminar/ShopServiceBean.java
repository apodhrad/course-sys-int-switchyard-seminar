package switchyard_seminar;

import javax.inject.Inject;

import org.switchyard.Context;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.ReferenceInvoker;
import org.switchyard.component.bean.Service;

import switchyard_seminar.accounting.AccountResponse;
import switchyard_seminar.accounting.AccountingService;
import switchyard_seminar.inventory.InventoryRequest;
import switchyard_seminar.model.Order;
import switchyard_seminar.model.OrderStatus;
import switchyard_seminar.shipment.ShipmentService;

@Service(ShopService.class)
public class ShopServiceBean implements ShopService {

	@Inject
	Context context;

	@Reference("InventoryRequestService")
	@Inject
	private ReferenceInvoker inventoryRequestService;

	@Inject
	@Reference
	AccountingService accountingService;

	@Inject
	@Reference
	OrderStatusService orderStatusService;

	@Inject
	@Reference
	ShipmentService shipmentService;

	@Override
	public String submitOrder(Order order) throws Exception {
		// Initialize order status
		OrderStatus orderStatus = new OrderStatus(order);
		orderStatusService.save(orderStatus);

		// Send text file to /target/inbox.inventory
		inventoryRequestService.newInvocation().setProperty("orderId", Long.toString(order.getId()))
				.invoke(new InventoryRequest(order.getItems()));

		// Assign invoice id and invoice status
		AccountResponse accountResponse = accountingService.account(order);
		orderStatus.setInvoiceId(accountResponse.getInvoiceId());
		orderStatus.setInvoiceStatus(accountResponse.getStatus());
		orderStatusService.save(orderStatus);
		
		// Deliver the order
		shipmentService.delivery(order.getAddress());

		return null;
	}

}
