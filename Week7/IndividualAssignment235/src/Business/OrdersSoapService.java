package Business;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import beans.Order;

@WebService()
public class OrdersSoapService {

	@WebMethod()
	public String sayHello(String name) {
	    System.out.println("Hello: " + name);
	    return "Hello " + name + "!";
	}
	@Inject void OrdersBusinessInterface(){
		
	}
	@WebMethod()
	public List<Order> getOrders(){
		List<Order> order = null;
		return order;
		
	}
}
