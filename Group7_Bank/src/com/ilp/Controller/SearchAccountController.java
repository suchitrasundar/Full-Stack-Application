package com.ilp.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.*;
import com.ilp.Services.BankEmployeeServices;

public class SearchAccountController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("View Account");
		String CCustomerId= req.getParameter("CustomerId").trim();
		String aacc_ID= req.getParameter("accountId").trim();
		int acc_ID=0;
		int CustomerId=0;
		if(CCustomerId.equals("")&& aacc_ID.equals("")) {
			acc_ID=0;
			CustomerId=0;
		}
		else if(CCustomerId.equals("")) {
			 acc_ID=Integer.parseInt(aacc_ID);
		}
		else if(aacc_ID.equals("")) {
			CustomerId=Integer.parseInt(CCustomerId);
		}
		
		BankEmployeeServices bes= new BankEmployeeServices();
		ArrayList<CreateAccount> accExist = bes.SearchAccount(CustomerId,acc_ID);
		System.out.println(accExist);
		if (accExist != null) {
			req.setAttribute("accExist", accExist);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("AccountResult.jsp");
			requestDispatcher.forward(req, resp);
		
		}
	}

}
