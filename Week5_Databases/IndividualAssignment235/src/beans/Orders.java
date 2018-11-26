package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Orders {
	List<Orders> orders;
	Orders(){
		Orders dummy = null;
		orders.add(dummy);
	}
	public void setOrders(List<Orders> orders1) {
		orders = orders1;
	}
	public List<Orders> getOrders() {
		return orders;
	}
}
