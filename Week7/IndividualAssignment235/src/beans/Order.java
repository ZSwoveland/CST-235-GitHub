package beans;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	int orderNumber;
	String productName;
		
	Order(){
		
	}
	Order(int orNumber, String proName){
		orderNumber = orNumber;
		productName = proName;
	}
	
	public void setOrderNumber(int number) {
		orderNumber = number;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setProductName(String name) {
		productName = name;
	}
	public String getProductName() {
		return productName;
	}
}
