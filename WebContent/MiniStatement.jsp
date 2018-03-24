<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.List" %>
    <%@page import="co.Transaction" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction Details</title>
<%List tlist=(List)session.getAttribute("transList");
request.setAttribute("tList", tlist);
%>
</head>
<body>
<h2 align="center">World Wide Bank</h2>
	<h3 align="center">Mini Statement :</h3>
<table> 
<thead> <tr>
<td>Transaction Id</td><td>Transaction Type</td><td>Transaction Amt</td>
<td>Date</td><td>Acc No</td></tr></thead>
<c:forEach items="${tList}" var="transaction">
<tr>
<td><c:out value="${transaction.tId}"></c:out></td>
<td><c:out value="${transaction.tType}"/></td>
<td><c:out value="${transaction.tamount}"/></td>
<td><c:out value="${transaction.tdate}"/></td>
<td><c:out value="${transaction.accountNumber}"/></td></tr>
</c:forEach>
</table>
<form action="SuccessCustomer.jsp">
</form>
</body>
</html>