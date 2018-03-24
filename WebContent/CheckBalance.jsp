*<%@page import="com.ActionCustomerLogin"%>
<%@page import="com.syntel.test.Test"%>
<%@page import="co.Account"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.button{
 background-color:white;
    width: 10em;  height: 2em;
}
hr {color: sienna;}
p {margin-left: 20px;}
body {background-image: url("images/atm-pin1.png");}
</style>


</head>
<body>

<%! %>
<h1>Current Balance</h1>
Your Balance is :<%
HttpSession session1=request.getSession(false);
		if(session1!=null){
			
Test t=new Test();
if(session!=null){
 Integer  accountNumber3=Integer.parseInt(session.getAttribute("accountNumber").toString());
 
 
 int currentAmount=t.checkBalance(accountNumber3);
 out.println(currentAmount);
	

}else{
	out.print("Please login first");
	request.getRequestDispatcher("Login.jsp").include(request, response);
}
request.getRequestDispatcher("withdrawDisplay.jsp").include(request, response);
		}else{
	out.print("Please login first");
	request.getRequestDispatcher("Login.jsp").include(request, response);
}


%>
