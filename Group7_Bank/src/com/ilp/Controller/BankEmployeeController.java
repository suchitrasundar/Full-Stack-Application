package com.ilp.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.BankEmployee;
import com.ilp.Services.BankEmployeeServices;

/**
 * Servlet implementation class BankEmployeeController
 */
public class BankEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankEmployeeController() {
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
		try {
			String empId = request.getParameter("empId").trim();
			String empPassword = request.getParameter("empPassword").trim();
//			String empName = request.getParameter("empName").trim();
//			String empType = request.getParameter("empType").trim();
			BankEmployee userToVerify = new BankEmployee();
			userToVerify.setEmpId(empId);
			userToVerify.setEmpPassword(empPassword);
			BankEmployeeServices bankServices= new BankEmployeeServices();
			if(bankServices.autenticateService(userToVerify)) {
				response.sendRedirect("Home.html");
			}
			else {
				response.sendRedirect("wrong_login.html");
			}
		}
		catch(NullPointerException e) {
			System.out.println("Invalid form submission");
		}
	}

}
