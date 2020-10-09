package com.ilp.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.Customer;
import com.ilp.Services.BankEmployeeServices;

public class SearchAllCustomerDetailsController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IN_SearchAllCustomerDetails_CONTROLLER");
		
		
		BankEmployeeServices bankempServices = new BankEmployeeServices();
		ArrayList<Customer> cust=new ArrayList<>();
		cust=bankempServices.showAllCustomerDetails();
		if (cust != null) {
			req.setAttribute("allcust", cust);
			RequestDispatcher requestDispatcher = req
					.getRequestDispatcher("viewallstatuscustomer.jsp");
			requestDispatcher.forward(req, resp);

		}
		
	}
}
