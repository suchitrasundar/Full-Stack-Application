package com.ilp.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.Services.*;

/**
 * Servlet implementation class AccountDeleteController
 */
public class AccountDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountDeleteController() {
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
		long id = Long.parseLong(request.getParameter("accId"));
		String accType=request.getParameter("selectact");
		BankEmployeeServices service = new BankEmployeeServices();
		
		boolean isDeleted = service.accDelete(id,accType);
		if(isDeleted)
		{
			response.sendRedirect("AccountDeletionSucess.html");
		}
		else
		{
			response.sendRedirect("AccountDeletionFailed.html");
	
		}
	}

}
