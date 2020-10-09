package com.ilp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.*;
import com.ilp.Services.*;

public class DeleteCustomerController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IN_DELETE_CUSTOMER_CONTROLLER");
		int cust_Id = Integer.parseInt((req.getParameter("customerId").trim()));
		int cust_ssn = Integer.parseInt((req.getParameter("ssn").trim()));
		String cust_Name = req.getParameter("custname").trim();
		int cust_age = Integer.parseInt((req.getParameter("age").trim()));
		BankEmployeeServices bankempServices = new BankEmployeeServices();
		boolean a=bankempServices.deleteCustomer(cust_Id,cust_ssn,cust_Name,cust_age);
		if (a) {
			resp.sendRedirect("CustomerDeletionSucess.html");

		}else {
			resp.sendRedirect("CustomerDeletionFailure.html");
		}
	}
}
