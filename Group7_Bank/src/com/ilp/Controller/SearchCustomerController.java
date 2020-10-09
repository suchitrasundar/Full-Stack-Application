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

/**
 * Servlet implementation class SearchCustomerController
 */
public class SearchCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("View CUstomer");
		String CCustomerId= request.getParameter("CustomerId").trim();
		String ssn=request.getParameter("SSN_NO").trim();
		int SSN_NO=0;
		int CustomerId=0;
		if(CCustomerId.equals("") && ssn.equals("") ) {
			 SSN_NO=0;
			 CustomerId=0;
		}
		else if(CCustomerId.equals("")) {
			 SSN_NO= Integer.parseInt(ssn);
		}
		else if(ssn.equals("")) {
			 CustomerId=Integer.parseInt(CCustomerId);
		}
		
		
		
		BankEmployeeServices CustomerServices= new BankEmployeeServices();
		ArrayList<Customer> CustExist = CustomerServices.SearchCustomer(CustomerId,SSN_NO);
		System.out.println(CustExist);
		if (CustExist != null) {
			request.setAttribute("CustExist", CustExist);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("CustomerResult.jsp");
			requestDispatcher.forward(request, response);
		
	}
	}
}
