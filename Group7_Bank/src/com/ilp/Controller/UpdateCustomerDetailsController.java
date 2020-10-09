package com.ilp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.Customer;
import com.ilp.Services.BankEmployeeServices;

public class UpdateCustomerDetailsController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("custId"));
		long ssn = Long.parseLong(req.getParameter("ssn"));	
		System.out.println("IN UPDATE CONTROLLER"+id+" "+ssn);
		BankEmployeeServices service = new BankEmployeeServices();
		Customer employee = service.searchcust(id,ssn);
		if (employee.getCustId()!=0) {
			req.setAttribute("cust", employee);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Update_Customer.jsp");
			requestDispatcher.forward(req, resp);

		}
		else {
			resp.sendRedirect("wrong_update.html");
		}
	}

}
