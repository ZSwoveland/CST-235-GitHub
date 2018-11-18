package Business;

import java.util.List;

import javax.ejb.Local;
import javax.inject.Inject;
import beans.Order;
import beans.Orders;

@Local
public interface OrdersBusinessInterface {
	@Inject
	public void test();
	public List<Order> getOrders();
	public void setOrders(List<Orders> orders);
}
