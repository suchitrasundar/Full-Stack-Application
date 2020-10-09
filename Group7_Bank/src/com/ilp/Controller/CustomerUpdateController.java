package com.ilp.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.Services.*;
/**
 * Servlet implementation class CustomerUpdateController
 */
public class CustomerUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateController() {
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
		long id = Long.parseLong(request.getParameter("custId"));
		long ssn = Long.parseLong(request.getParameter("custSSN"));	
		String oldName = request.getParameter("custName");
		String newName = request.getParameter("newcust_name");
		String oldAddress = request.getParameter("oldadd");
		String newAddress = request.getParameter("new_adrs");
		System.out.println(id + " " + " "+ ssn + " "+ oldName + " "+ newName + " " + oldAddress + " " + newAddress);
		int oldAge = Integer.parseInt(request.getParameter("oldage"));
		int newAge = Integer.parseInt(request.getParameter("new_age"));
		System.out.println(id + " " + " "+ ssn + " "+ oldName + " "+ newName + " " + oldAge);
		BankEmployeeServices service = new BankEmployeeServices();
		boolean isUpdated = service.cusUpdate(id, ssn, newName, newAddress, newAge);
		if(isUpdated)
		{
			response.sendRedirect("succes_update.html");
		}
		else
		{
			response.sendRedirect("error_update.html");
		}
		
	}

}
