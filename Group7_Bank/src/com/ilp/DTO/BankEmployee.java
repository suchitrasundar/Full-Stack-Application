package com.ilp.DTO;

public class BankEmployee {
	private String empId;
	private String empPassword;
	private String empName;
	private String empType;
	public BankEmployee() {
	}
	public BankEmployee(String empId, String empPassword, String empName, String empType) {
		this.empId = empId;
		this.empPassword = empPassword;
		this.empName = empName;
		this.empType = empType;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public boolean validate() {
		if(this.empId.length() <= 0 || this.empId.length() > 10) {
			return false;
		}
		if(this.empPassword.length() <=0 || this.empPassword.length() > 20) {
			return false;
		}
		return true;
	}
}
