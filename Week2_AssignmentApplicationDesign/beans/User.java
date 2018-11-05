package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UICommand;

@ManagedBean
@ViewScoped
public class User {
	String firstName;
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
}
