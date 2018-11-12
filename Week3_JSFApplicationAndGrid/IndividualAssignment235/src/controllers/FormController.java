package controllers;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import beans.User;
public class FormController {
	public void onSubmit(User user){
		FacesContext context = FacesContext.getCurrentInstance();
		user = context.getApplication().evaluateExpressionGet(context, "#{firstName}", User.class);
		user = context.getApplication().evaluateExpressionGet(context, "#{lastName}", User.class);
	}
	public String onFlash(User user){
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		user = (User) flash.put("firstName", user.getfirstName());
		user = (User) flash.put("lastName", user.getlasstName());
		return "confirm?faces-redirect=true";
	}
}
