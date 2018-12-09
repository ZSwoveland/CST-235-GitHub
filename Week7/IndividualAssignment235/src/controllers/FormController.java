package controllers;
import java.util.List;

import java.sql.*;

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
	Order order = null;
	OrdersBusinessService service = null;
	AnotherOrdersBusinessService another = null;
	MyTimerService timer = null;
	
	/*public void onSubmit(User user){
		FacesContext context = FacesContext.getCurrentInstance();
		user = context.getApplication().evaluateExpressionGet(context, "#{firstName}", User.class);
		user = context.getApplication().evaluateExpressionGet(context, "#{lastName}", User.class);
		timer.setTimer(10000);
		service.test();
		another.test();
		getAllOrders();
		insertOrder();
		getAllOrders();
		service.sendOrder(order);
	}*/
	public String onLogoff() {
		// Invalidate the Session to clear the security token
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
		// Redirect to a protected page (so we get a full HTTP Request) to get Login Page
		return "TestResponse.xhtml?faces-redirect=true";

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
	private void insertOrder() {
		Connection conn = null;
		String local = "INSERT INTO testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('001122334455','This was inserted new', 25.00, 100)";
		Statement s;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
			s = conn.createStatement();
			s.executeUpdate(local);
			
		}
		catch(SQLException e) {
			
		}

		
	}
	private void getAllOrders() {
		
			Connection conn = null;
			String local = "SELECT * FROM testapp.ORDERS";
			Statement s;
			ResultSet rs;
			try {
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
				
				System.out.println("SUCCESS!!!!!!!!!!!!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Failure!!");
				
			}finally {
				if(conn == null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					try {
						s = conn.createStatement();
						rs = (ResultSet) conn.prepareStatement(local);
						while(rs != null) {
							rs.getInt(3);
							rs.getString(1);
							rs.getFloat(2);
							System.out.println(rs);
							rs.next();
						}
						conn.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			
		
		
	}
}
