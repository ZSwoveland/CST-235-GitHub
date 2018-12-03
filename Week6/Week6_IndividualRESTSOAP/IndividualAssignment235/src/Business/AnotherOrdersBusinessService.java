package Business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.enterprise.inject.Alternative;
import javax.ejb.Stateless;
import beans.Order;
/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@LocalBean
@Alternative
public class AnotherOrdersBusinessService {
	Order order;
	List<Order> orders;
    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() {
        // TODO Auto-generated constructor stub
    	order.setOrderNumber(10);
    	order.setProductName("LogicTech");
    }
    public void test() {
    	System.out.println("Hello from the AnotherOrdersBusinessService!");
    }
    public List<Order> getOrders() {
    	return orders;
    }
    public void setOrders(List<Order> order) {
    	orders = order;
    }
    
}
