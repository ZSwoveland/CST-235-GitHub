package Business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.enterprise.inject.Alternative;
import javax.ejb.Stateless;
import beans.Order;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@LocalBean
@Alternative
public class OrdersBusinessService {
	Order order;
	List<Order> orders;
    /**
     * Default constructor. 
     */
    public OrdersBusinessService() {
        // TODO Auto-generated constructor stub
    	order.setOrderNumber(25);
    	order.setProductName("AlienWare");
    }

    public void test() {
    	System.out.println("Hello from the OrdersBusinessService!");
    }
    public List<Order> getOrders() {
    	return orders;
    }
    public void setOrders(List<Order> order) {
    	orders = order;
    }
}
