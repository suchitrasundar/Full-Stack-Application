package com.ilp.Controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.CreateAccount;
import com.ilp.Services.*;

@WebServlet("/account")
public class CreateAccountController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public CreateAccountController() {
		super();
	}
	
	// get request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	}
	
	// post request
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			//int accountId = Integer.parseInt(request.getParameter("accountId").trim());
			int customerId = Integer.parseInt(request.getParameter("customerId").trim());
			String accountType = request.getParameter("accountType").trim();
			int depositAmount = Integer.parseInt(request.getParameter("depositAmount").trim());
			CreateAccount accountInfo = new CreateAccount();
			//accountInfo.setAccountId(accountId);
			accountInfo.setAccountType(accountType);
			accountInfo.setCustomerId(customerId);
			accountInfo.setDepositAmount(depositAmount);
			System.out.println(customerId+","+accountType+","+depositAmount+",");
			BankEmployeeServices createAccountService = new BankEmployeeServices();
			boolean isAccountCreated = createAccountService.createAccount(accountInfo);
			if(isAccountCreated) {
				
				System.out.println(" Account Created Successfully! ");
				response.sendRedirect("AccountCreationSucess.html");
			} else {
				System.out.println(" Failure to create Account!! ");
				response.sendRedirect("AccountCreationFailure.html");
			}
		}catch(Exception ex) {
			System.out.print(ex.getMessage());
			ex.printStackTrace();
		}
		
		
	}
}
