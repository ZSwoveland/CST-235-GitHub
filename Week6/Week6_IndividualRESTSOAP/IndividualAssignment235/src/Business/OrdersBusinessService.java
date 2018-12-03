package Business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.ejb.LocalBean;
import javax.enterprise.inject.Alternative;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.ejb.Stateless;
import beans.Order;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@LocalBean
@Alternative
public class OrdersBusinessService {
	Order order;
	List<Order> orders;
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;
    /**
     * Default constructor. 
     */
    public OrdersBusinessService() {
        // TODO Auto-generated constructor stub
    	order.setOrderNumber(25);
    	order.setProductName("AlienWare");
    	sendOrder(order);
    }
    public void sendOrder(Order order) {
    	System.out.println(order);
    	try {
    		Connection connection = (Connection) connectionFactory.createConnection();
    		Session session = ((javax.jms.Connection) connection).createSession(false,Session.AUTO_ACKNOWLEDGE);
    		MessageProducer messageProducer = session.createProducer(queue);
    		TextMessage message1 = session.createTextMessage();
    		message1.setText("This is test message");
    		messageProducer.send(message1);
    		connection.close();
    	}
    	catch(JMSException | SQLException e) {
    		e.printStackTrace();
    	}
    }
    public void test() {
    	System.out.println("Hello from the OrdersBusinessService!");
    }
    public List<Order> getOrders() {
    	return orders;
    }
    public void setOrders(List<Order> order) {
    	orders = order;
    }
}
