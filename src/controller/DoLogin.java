package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String customerId = request.getParameter("customerId");
		
		//PErform vusiness logic. return a bean as a result.
		CustomerService service = new CustomerService();
		Customer customer = service.findCustomer(customerId);
		request.setAttribute("customer", customer);
		
		// We can iterate over lists using for each in JSTL
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("id006", " Kim", "kim@hansung.ac.kr"));
		customers.add(new Customer("id007", " Lee", "lee@hansung.ac.kr"));
		customers.add(new Customer("id008", " Park", "park@hansung.ac.kr"));
		
		request.setAttribute("customerList", customers);
		
		
	
		
		
		String page = null;
		
		if(customer == null)
			page = "/view/error.jsp";
		
		else
			page = "/view/success.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
