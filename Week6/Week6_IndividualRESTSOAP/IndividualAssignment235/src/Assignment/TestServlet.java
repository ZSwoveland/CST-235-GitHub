package Assignment;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String override = "";
	int times = 0;
	String firstName = "Zachary";
	String lastName = "Swoveland";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		override = "overriden";
	}
	public void init() throws ServletException {
		// Override
		times = times + 1;
		System.out.print("\nINIT overriden");
	    
	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.print("\nDestroy Output: " + override);
		System.out.print("\nHow many times Destroyed: " + times);
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		request.setAttribute(firstName, "Zachary");
		request.getRequestDispatcher("TestResponse.jsp").forward(request, response);
		request.setAttribute(lastName, "Swoveland");
		request.getRequestDispatcher("TestResponse.jsp").forward(request, response);
		
		/*String title = "Handling 2 Html Parameters";
		String docType = 
				"<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + 
				"<html>\n" +
	            "<head><title>" + title + "</title></head>\n" +
	            "<body bgcolor = \"#f0f0f0\">\n" +
	               "<h1 align = \"center\">" + title + "</h1>\n" +
	               "<ul>\n" +
	                  "  <li><b>First Name</b>: "
	                  + request.setAttribute("firstName", "Zachary")("firstName") + "\n" +
	                  "  <li><b>Last Name</b>: "
	                  + request.getParameter("lastName") + "\n" +
	               "</ul>\n" +
	            "</body>" +
	         "</html>");*/
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		response.setContentType("text/html");
		if(request.getParameter("Submit") != null) {
			if(firstName.equals("Zachary") && lastName.equals("Swoveland")) {
				response.getWriter().println("<html><body>Welcome Zachary Swoveland!!!</body></html>");
			}else {
				 response.getWriter().println("<html><body>Not Valid !!!</body></html>");
			}
			 request.getRequestDispatcher("TestForm.jsp").forward(request, response);
		}
		else {
			if(firstName.equals("Zachary") && lastName.equals("Swoveland")) {
				response.getWriter().println("<html><body>Welcome Zachary Swoveland!!!</body></html>");
			}else {
				 response.getWriter().println("<html><body>Not Valid !!!</body></html>");
			}
			request.getRequestDispatcher("TestForm.jsp").forward(request, response);
		}
		
	}
}
