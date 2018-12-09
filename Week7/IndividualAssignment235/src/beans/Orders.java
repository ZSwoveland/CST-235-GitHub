package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ManagedBean
@ViewScoped
public class Orders {
	List<Orders> orders;
	Orders(){
		Orders dummy = null;
		orders.add(dummy);
	}
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrdersAsJson(){
		List<Order> order = null;
		return order;
	}
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Order[] getOrdersAsXML() {
		Order[] order = null;
		return order;
	}
	public void setOrders(List<Orders> orders1) {
		orders = orders1;
	}
	public List<Orders> getOrders() {
		return orders;
	}
}
