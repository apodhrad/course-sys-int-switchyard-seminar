package switchyard_seminar;

import switchyard_seminar.model.Order;

public interface ShopService {

	String submitOrder(Order order) throws Exception;
}
