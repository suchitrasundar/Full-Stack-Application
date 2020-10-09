package com.ilp.DTO;

/**
 * This Class is the model for a customer data transfer object
 * @author 1878605
 *
 */
public class Customer {
	// variable initialization
	private long custId;
	//private static long COUNTER;
	private String custName;
	private int custAge;
	private int custSSN;
	private String custAddress;
	private String custState;
	private String custCity;
	
	// Declaration of getter and setter
	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getCustAge() {
		return custAge;
	}

	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}

	public int getCustSSN() {
		return custSSN;
	}

	public void setCustSSN(int custSSN) {
		this.custSSN = custSSN;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustState() {
		return custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}
	
	/**
	 * Constructor to create object of type Customer
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
		//this.custId = COUNTER++;
	}

}
