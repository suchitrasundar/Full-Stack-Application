package com.ilp.Services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ilp.DAO.BankEmployeeDao;
import com.ilp.DTO.*;

public class BankEmployeeServices {
	public boolean autenticateService(BankEmployee userToVerify) {
		if(!userToVerify.validate()) {
			return false;
		}
		BankEmployeeDao bank = new BankEmployeeDao();
		BankEmployee storedUser = bank.authenticate(userToVerify.getEmpId());
		if(storedUser == null) {
			
			return false;
		}
		if(!userToVerify.getEmpId().equals(storedUser.getEmpId())) {
			System.out.println(userToVerify.getEmpId());
			System.out.println(storedUser.getEmpId());
			
			return false;
		}
		if(!userToVerify.getEmpPassword().equals(storedUser.getEmpPassword())) {
			
			return false;
		}
		return true;
	}
	
	public boolean createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		BankEmployeeDao bankDao = new BankEmployeeDao();
		boolean isCustomerCreated = bankDao.addCustomer(customer);
		return isCustomerCreated;
	}
	public Customer searchcust(int cid,long ssn) {
		BankEmployeeDao bankdao=new BankEmployeeDao();
		Customer cust=bankdao.getcustdetails(cid,ssn);
		return cust;
		
	}
	public boolean cusUpdate(long  id, long ssn , String newName, String newAdddress, int newAge)  {
		BankEmployeeDao cusUpdateDao = new BankEmployeeDao();
		boolean update = cusUpdateDao.cusUpdate(id, ssn, newName, newAdddress, newAge);
		return update;
	}
	
	public boolean deleteCustomer(int cid,int ssn, String name,int age) {
		BankEmployeeDao bedao=new BankEmployeeDao();
		boolean result=bedao.deleteCustomer(cid,ssn,name,age);
		return result;
	}
	
	public ArrayList<Customer> showAllCustomerDetails() {
		BankEmployeeDao bedao= new BankEmployeeDao();
		return bedao.showAllCustomerDetails();
		
	} 
	public Boolean createAccount(CreateAccount account) throws SQLException {
		BankEmployeeDao dao = new BankEmployeeDao();
		Boolean isdeposited = dao.depositMoney(account);
		return isdeposited;
	}
	public boolean accDelete(long id,String accType)
	{
		BankEmployeeDao accDeleteDao = new BankEmployeeDao();
		boolean deleted = accDeleteDao.accDelete(id,accType);
		return deleted;
		
	}
	public ArrayList<Customer> SearchCustomer(int CustomerId,int SSN_NO)
	{
	BankEmployeeDao CustomerDao= new BankEmployeeDao();
	ArrayList< Customer> CustExist= CustomerDao.SearchCustomer(CustomerId,SSN_NO);
	return CustExist;
	}
	public ArrayList<CreateAccount> showAllAccountDetails() {
		BankEmployeeDao bedao= new BankEmployeeDao();
		return bedao.showAllAccountDetails();
	}
	public ArrayList<CreateAccount> SearchAccount(int CustomerId,int accid)
	{
	BankEmployeeDao bedao= new BankEmployeeDao();
	ArrayList<CreateAccount> acc= bedao.SearchAccount(CustomerId,accid);
	return acc;
	}
}
