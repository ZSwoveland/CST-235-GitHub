package beans;

import java.security.Principal;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@ManagedBean
@SessionScoped
public class User {
	@NotNull()
	@Size(min=5, max=15)
	String firstName;
	@NotNull()
	@Size(min=5, max=15)
	String lastName;
	UICommand link;
	User(String fName, String lName){
		firstName = fName;
		lastName = lName;
	}
	public void setfirstName(String name) {
		firstName = name;
	}
	public String getfirstName() {
		return firstName;
	}
	public void setlastName(String name) {
		lastName = name;
	}
	public String getlasstName() {
		return lastName;
	}
	@PostConstruct
	public void init() {
		// Get the logged in Principle
		Principal principle= FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
			if(principle == null)
			{
				setfirstName("Unknown");
				setlastName("");
			}
			else
			{
				setfirstName(principle.getName());
				setlastName("");
			}
	}

}
