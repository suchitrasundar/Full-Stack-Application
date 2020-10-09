package com.ilp.Controller;

// imports
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.*;
import com.ilp.Services.*;


public class CreateCustomerController extends HttpServlet {
	
/**
 * Servlet implementation class CreateCustomerController
 */
	
	private static final long serialVersionUID = 1L;

	
	public CreateCustomerController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			//long CustId=Long.parseLong(request.getParameter("CustomerID").trim());
			String CustSSN = request.getParameter("CustomerSSN").trim();
			String CustName = request.getParameter("CustomerName").trim();
			String CustAge = request.getParameter("CustomerAge").trim();
			String CustAddress = request.getParameter("CustomerAddress").trim();
			String CustState = request.getParameter("State").trim();
			String CustCity = request.getParameter("City").trim();
			System.out.println("CustCity"+CustCity);
			// convert raw input to data object
			Customer customer = new Customer();	
			//customer.setCustId(CustId);
			customer.setCustSSN(Integer.parseInt(CustSSN));
			customer.setCustName(CustName);
			customer.setCustAge(Integer.parseInt(CustAge));
			customer.setCustAddress(CustAddress);
			customer.setCustState(CustState);
			customer.setCustCity(CustCity);
			System.out.println("CustID"+customer.getCustId());
			
			// Store the data
			BankEmployeeServices bankService = new BankEmployeeServices();
			boolean isCustomerCreated = bankService.createCustomer(customer);
			if(isCustomerCreated) {
				System.out.println(" Customer Created Successfully! ");
				response.sendRedirect("CustomerCreationSucess.html");
			} else {
				System.out.println(" Failure to create customer!! ");
				response.sendRedirect("CustomerCreationFailure.html");
			}
	}

}
