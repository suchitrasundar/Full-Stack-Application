package com.ilp.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.ilp.Helper.DBConnectionHelper;
import com.ilp.DTO.*;
public class BankEmployeeDao {
	public BankEmployee authenticate(String userId) {
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet resultSet = null;
		BankEmployee storedUser = new BankEmployee();
		try {
			String sql = "SELECT * FROM BankEmployee WHERE EmpId ='" + userId+"'";
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(sql);
			/*if(!resultSet.next()) {
				storedUser = null;
			}*/
			while (resultSet.next()) { 
				storedUser.setEmpId(resultSet.getString(1));
				storedUser.setEmpPassword(resultSet.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("QUERY NOT EXECUTED");
			e.printStackTrace();
		}
		finally {
			if(resultSet != null) {
				try {
					resultSet.close();
					System.out.println("RESULTSET SUCCESSFULLY CLOSED");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
					System.out.println("CONNECTION SUCCESSFULLY CLOSED");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return storedUser;
	}
public boolean addCustomer(Customer customer) {
		

		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		PreparedStatement pStmt = null;
		int status = 0;
		{
			try {
				connection.setAutoCommit(false);
				// SQL Query to insert data
				String sql = "INSERT INTO CUSTOMER_DETAILS " +
				"VALUES (cust_id.nextval,?,?,?,?,?,?)";
			
				pStmt = connection.prepareStatement(sql);
				
				pStmt.setString(1, customer.getCustName());
				pStmt.setInt(2, customer.getCustAge());
				pStmt.setInt(3, customer.getCustSSN());
				pStmt.setString(4, customer.getCustAddress());
				pStmt.setString(5,  customer.getCustState());
				pStmt.setString(6, customer.getCustCity());
				
				
				status = pStmt.executeUpdate();
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Check If Data Inserted Correctly!
		if(status == 1) {
			System.out.println("Data Inserted Successfully!!");
			return true;
		}
		
		// Check Preapred Statement object is closed
		if(pStmt != null)
			try {
				pStmt.close();
				System.out.println(" Prepared Statement Successfully Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		// Check Connection is closed
		if(connection != null)
			try {
				connection.close();
				System.out.println(" Connection Closed Successfully!! ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public Customer getcustdetails(int cid, long ssn) {
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet resultSet = null;
		Customer temp = new Customer();
		{
			try {
				String sql = "select * from customer_details where customer_id='"+cid+"' and ssn_no='"+ssn+"'";
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);
				while (resultSet.next()) {
					int c_id = resultSet.getInt(1);
					String c_name=resultSet.getString(2);
					int c_age= resultSet.getInt(3);
					int c_ssn= resultSet.getInt(4);
					String c_address = resultSet.getString(5);
					String c_State = resultSet.getString(6);
					String c_City = resultSet.getString(7);
					//Customer temp = new Customer();
					temp.setCustId(c_id);
					temp.setCustName(c_name);
					temp.setCustAge(c_age);
					temp.setCustSSN(c_ssn);
					temp.setCustAddress(c_address);
					temp.setCustState(c_State);
					temp.setCustCity(c_City);
					
					
				}
				//System.out.println(tempEmployee.getEmpAge());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (stmt != null)
			try {
				stmt.close();
				System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (connection != null)
			try {
				connection.close();
				System.out.println("CONNECTION SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return temp;
		
	}
	public boolean deleteCustomer(int cid,int ssn,String name, int age) {
		Connection connection = null;	
		DBConnectionHelper helper = new DBConnectionHelper();
		connection = helper.getOracleConnection();
		PreparedStatement statement = null;
		int status = 0 ;
		try {
			connection.setAutoCommit(false);
			String sql = "delete from customer_details where customer_name=? and customer_id=? and age=? and ssn_no=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, cid);
			statement.setInt(3, age);
			statement.setInt(4, ssn);
			
			
			
			status = statement.executeUpdate();
		
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	if (status == 1) {
		System.out.println("Data Deleted successfully");
		return true;
	}

	if  (statement!= null)
		try {
			statement.close();
			System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	if (connection != null)
		try {
			connection.close();
			System.out.println("CONNECTION SUCCESSFULLY CLOSED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return false;
		
	}
	public boolean cusUpdate(long  id, long ssn , String newName, String newAdddress, int newAge)  {
		Connection connection = null;	
		DBConnectionHelper helper = new DBConnectionHelper();
		connection = helper.getOracleConnection();
		PreparedStatement statement = null;
		int status = 0 ;
		try {
			connection.setAutoCommit(false);
			String sql = "update customer_Details set customer_name = ?, address = ?, age =? where customer_id = ? and ssn_no =?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, newName);
			statement.setString(2, newAdddress);
			statement.setInt(3, newAge);
			statement.setLong(4, id);
			statement.setLong(5, ssn);
			status = statement.executeUpdate();
		
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	if (status == 1) {
		System.out.println("Data inserted successfully");
		return true;
	}

	if  (statement!= null)
		try {
			statement.close();
			System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	if (connection != null)
		try {
			connection.close();
			System.out.println("CONNECTION SUCCESSFULLY CLOSED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return false;

}
	public ArrayList<Customer> showAllCustomerDetails() {
		ArrayList<Customer> arr=new ArrayList<>();
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet resultSet = null;
		//Customer temp = new Customer();
		{
			try {
				String sql = "select * from customer_details ";
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);
				while (resultSet.next()) {
					int c_id = resultSet.getInt(1);
					String c_name=resultSet.getString(2);
					int c_age= resultSet.getInt(3);
					int c_ssn= resultSet.getInt(4);
					String c_address = resultSet.getString(5);
					String c_State = resultSet.getString(6);
					String c_City = resultSet.getString(7);
					Customer temp = new Customer();
					temp.setCustId(c_id);
					temp.setCustName(c_name);
					temp.setCustAge(c_age);
					temp.setCustSSN(c_ssn);
					temp.setCustAddress(c_address);
					temp.setCustState(c_State);
					temp.setCustCity(c_City);
					
					arr.add(temp);
					
				}
				//System.out.println(tempEmployee.getEmpAge());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (stmt != null)
			try {
				stmt.close();
				System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (connection != null)
			try {
				connection.close();
				System.out.println("CONNECTION SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return arr;
	} 
	public boolean accDelete(long id,String accType)
	{
		Connection connection = null;	
		DBConnectionHelper helper = new DBConnectionHelper();
		connection = helper.getOracleConnection();
		PreparedStatement statement = null;
		System.out.println("IN DELETE");
		int status = 0 ;
		String message = "Account has been deleted";
		String account_status = "Inactive";
		try {
			connection.setAutoCommit(false);
			String sql = "update account set ACCOUNT_STATUS = ?, message = ? where ACCOUNT_ID =? and account_type=? and ACCOUNT_STATUS in ('Pending', 'Active') ";
			statement = connection.prepareStatement(sql);
			statement.setString(1, account_status);
			statement.setString(2, message);
//			LocalDateTime datetime = LocalDateTime.now();
//			String timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(datetime);
//			System.out.println(timeStamp);
//			statement.setString(3,timeStamp);
			statement.setLong(3, id);
			statement.setString(4, accType);
			status = statement.executeUpdate();
		
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	if (status == 1) {
		System.out.println("Data updated successfully");
		return true;
	}

	if  (statement!= null)
		try {
			statement.close();
			System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	if (connection != null)
		try {
			connection.close();
			System.out.println("CONNECTION SUCCESSFULLY CLOSED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean depositMoney(CreateAccount account) throws SQLException {
		Connection connection = null;	
		DBConnectionHelper helper = new DBConnectionHelper();
		connection = helper.getOracleConnection();
		PreparedStatement statement = null;
		int status = 0 ;
		
		try {
			connection.setAutoCommit(false);
			//INSERT INTO account VALUES ('" +  account.getCustomerId() + "','acc_id.nextval','" + account.getDepositAmount() +"','"+ account.getAccountType() + "','"+ account.getStatus()+"','"+account.getMessage()+"','"+time +"')");
			String sql = "Insert into account values(?,acc_id.nextval,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, account.getCustomerId());
			statement.setInt(2, account.getDepositAmount());
			statement.setString(3,account.getAccountType());
			statement.setString(4,account.getStatus());
			statement.setString(5,account.getMessage());
			//CURRENT_TIMESTAMP
			LocalDateTime datetime = LocalDateTime.now();
			String timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(datetime);
			System.out.println(timeStamp);
			statement.setString(6,timeStamp);
			
			status = statement.executeUpdate();
		
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	if (status == 1) {
		System.out.println("Data updated successfully");
		return true;
	}

	if  (statement!= null)
		try {
			statement.close();
			System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	if (connection != null)
		try {
			connection.close();
			System.out.println("CONNECTION SUCCESSFULLY CLOSED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
	}
	public ArrayList<Customer> SearchCustomer(int CustomerId, int SSN_NO) {
		// TODO Auto-generated method stub

		ArrayList<Customer> CustExist= new ArrayList<>();
		
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet resultSet = null;
		{
			try {
				String sql = ("SELECT * FROM CUSTOMER_DETAILS  where CUSTOMER_ID ='"+
			CustomerId + "' OR SSN_NO ='"+ SSN_NO+"'");
				
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);
				while (resultSet.next()) {
					Customer t = new Customer();
					long CustomerId1=resultSet.getLong(1);
					t.setCustId(CustomerId1);
					String CustomerName= resultSet.getString(2);
					t.setCustName(CustomerName);
					int Age=resultSet.getInt(3);
					t.setCustAge(Age);
					int SSNNO=resultSet.getInt(4);
					t.setCustSSN(SSNNO);
					String Address=resultSet.getString(5);
					t.setCustAddress(Address);
					String State=resultSet.getString(6);
					t.setCustState(State);
					String City =resultSet.getString(7);
					t.setCustCity(City);
					
					
					CustExist.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (stmt != null)
			try {
				stmt.close();
				System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (connection != null)
			try {
				connection.close();
				System.out.println("CONNECTION SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return CustExist;
	}
	public ArrayList<CreateAccount> showAllAccountDetails() {
		ArrayList<CreateAccount> arr=new ArrayList<>();
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet resultSet = null;
		//Customer temp = new Customer();
		{
			try {
				String sql = "select * from account ";
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);
				while (resultSet.next()) {
					int c_id = resultSet.getInt(1);
					int account_id = resultSet.getInt(2);
					int deposit_Amount = resultSet.getInt(3);
					String account_type= resultSet.getString(4);
					String account_Status = resultSet.getString(5);
					String message = resultSet.getString(6);
					String last_updated = resultSet.getString(7);
					CreateAccount temp = new CreateAccount();
					temp.setCustomerId(c_id);
					temp.setAccountId(account_id);
					temp.setDepositAmount(deposit_Amount);
					temp.setAccountType(account_type);
					temp.setStatus(account_Status);
					temp.setMessage(message);
					temp.setTime(last_updated);
					
					arr.add(temp);
					
				}
				//System.out.println(tempEmployee.getEmpAge());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (stmt != null)
			try {
				stmt.close();
				System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (connection != null)
			try {
				connection.close();
				System.out.println("CONNECTION SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return arr;
	} 
	public ArrayList<CreateAccount> SearchAccount(int CustomerId, int accid) {
		// TODO Auto-generated method stub

		ArrayList<CreateAccount> arr= new ArrayList<>();
		
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet resultSet = null;
		{
			try {
				String sql = ("SELECT * FROM Account  where CUSTOMER_ID ='"+
			CustomerId + "' OR ACCOUNT_ID ='"+ accid+"'");
				
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);
				while (resultSet.next()) {
					CreateAccount abc=new CreateAccount();
					int CustomerId1=resultSet.getInt(1);
					abc.setCustomerId(CustomerId1);
					int Account_ID= resultSet.getInt(2);
					abc.setAccountId(Account_ID);
					int dept=resultSet.getInt(3);
					abc.setDepositAmount(dept);
					String accType=resultSet.getString(4);
					abc.setAccountType(accType);
					String accStatus=resultSet.getString(5);
					abc.setStatus(accStatus);
					String Message=resultSet.getString(6);
					abc.setMessage(Message);
					String Last =resultSet.getString(7);
					abc.setTime(Last);
					
					
					arr.add(abc);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (stmt != null)
			try {
				stmt.close();
				System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (connection != null)
			try {
				connection.close();
				System.out.println("CONNECTION SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return arr;
	}
}
