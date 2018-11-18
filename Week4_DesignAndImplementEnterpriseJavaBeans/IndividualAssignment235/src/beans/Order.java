package beans;






public class Order {
	int orderNumber;
	String productName;
		
	
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
