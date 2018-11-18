package controllers;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import Business.AnotherOrdersBusinessService;
import Business.OrdersBusinessService;
import beans.User;
import beans.Order;
import Business.MyTimerService;
public class FormController {
	OrdersBusinessService service = null;
	AnotherOrdersBusinessService another = null;
	MyTimerService timer = null;
	public void onSubmit(User user){
		FacesContext context = FacesContext.getCurrentInstance();
		user = context.getApplication().evaluateExpressionGet(context, "#{firstName}", User.class);
		user = context.getApplication().evaluateExpressionGet(context, "#{lastName}", User.class);
		timer.setTimer(10000);
		service.test();
		another.test();
	}
	public String onFlash(User user){
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		user = (User) flash.put("firstName", user.getfirstName());
		user = (User) flash.put("lastName", user.getlasstName());
		return "confirm?faces-redirect=true";
	}
	public void getService() {
		System.out.println(service.getOrders()); 
		System.out.println(another.getOrders()); 
	}
}
