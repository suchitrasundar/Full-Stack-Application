<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="design.css" />
    <script src="jsfunctions.js"></script>
  </head>
  <body>
  <header id="headd">
    <div class="navbar">
      <h2><span id="coloryellow">Group7</span> Bank</h2>
      <div id="back">
        <a href="Home.html">Home</a>
        <div class="customer">
          <button class="custbtn" onclick="myFunction()">
            Customer Management
            <i class="fa fa-caret-down"></i>
          </button>
          <div class="customer-content" id="custdropdown">
            <a href="CreateCustomerScreen.html">Add Customer</a>
            <a href="Customer_Update.html">Edit Customer</a>
            <a href="delete_customer.html">Delete Customer</a>
            <a href="searchAllCustomerDetails.html">Search ALL Customer Details</a>
          </div>
        </div>
        <div class="bank">
          <button class="bankbtn" onclick="myFunction1()">
            Account Management
            <i class="fa fa-caret-down"></i>
          </button>
          <div class="dropdown-content1" id="mybank">
            <a href="CreateAccount.html">Add bank Account</a>
            <a href="delete_account.html">Delete bank Account</a>
            <a href="viewAllAccount.html">View ALL bank Account</a>
          </div>
        </div>
        <a href="SearchCustomer.html">Search Customer Details</a>
        <a href="AccountSearch.html">Search Bank Account Details</a>
        <a href="login.html">Logout</a>
      </div>
    </div>
  </header>
<div id="centeralign">
<%@ page import="com.ilp.DTO.CreateAccount"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>

<h2>View all Accounts</h2>
<%
	ArrayList<CreateAccount> allaccList = (ArrayList<CreateAccount>) request.getAttribute("allAccounts");
%>

<table id="displaytable" class="center"  >
<tr>
<th>Account ID </th>
		<th>Customer ID </th>
		<th>Balance</th>
		<th>Account Type</th>
		<th>Account Status </th>		
		<th>Message </th>
		<th>Last Updated </th>
<th>Refresh</th>
</tr>
		<%
			Iterator myIterator = allaccList.iterator();
			while (myIterator.hasNext()) {
				CreateAccount ct = (CreateAccount) myIterator.next();
		%>
		
			<tr>
			<td><%=ct.getAccountId() %></td>
			<td><%=ct.getCustomerId()   %></td>
			<td><%=ct.getDepositAmount() %></td>
			<td><%=ct.getAccountType() %></td>
			<td><%=ct.getStatus()    %></td>
			<td><%=ct.getMessage()%></td>
			<td><%=ct.getTime()%></td>
			<td><a href="viewAllAccount.html">refresh</a></td>
			</tr>


		
		<%}%>
</table>
</div>
  <footer class="footer">
    <div class="abtus">
      <h3 id="coloryellow">About Us</h3>
      <p>
        The Group 7 bank provides a broad spectrum of services and banking
        solutions. Founded in it's late 20s, the bank has immensely curated
        dynamic solutions for it's customers to manage their transactions and
        accounts efficiently. It has been a great source of home loans for all
        the customers living in the city. The Group 7 covers various nuances of
        the bank services including credit cards, education and home loans.
      </p>
    </div>
    <div class="services">
      <h3 id="coloryellow">Services</h3>
      <p>Retail and Customer Banking</p>
      <p>Personal Internet Banking</p>
      <p>Corporate Internet Banking</p>
      <p>Debit and Credit Cards</p>
    </div>
    <div class="contactus">
      <h3 id="coloryellow">Contact Us</h3>
      <p>Email: group7@tcs.com</p>
      <p>Phone: 220 78965432</p>
      <p>Address: Albany, New York</p>
    </div>
    <br />
    <div class="copy" id="coloryellow">
      &copy; Copyright 2020 All Rights Reserved Group7Bank
    </div>
  </footer>
</body>
</html>