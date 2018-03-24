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
<h3> Select Note you want to withdraw</h3><br> <br>
<center>

<form action="ActionFastWithdraw">

<table border='0'> 
 
<tr>
<td>
<br> <br></td>
</tr>

<tr>
<td></td>
<td>
 <input type="submit" name="withdrawAmount" value="1000" class="button" />
</td>
</tr>
</table>
</form>
</center>
<center>

<form action="ActionFastWithdraw">
<table border='0'> 
<tr>
<td><br></td>
</tr>

<tr>
<td></td>
<td>
<input type="submit"  name="withdrawAmount" value="3000" class="button"/>
</td>
</tr>
</table>
</form>
</center>
<center>
<form action="ActionFastWithdraw">
<table border='0'> 
<tr>
<td><br></td>
</tr>

<tr>
<td></td>
<td>
<input type="submit"  name="withdrawAmount" value="5000" class="button"/>
</td>
</tr>
</table>
</form>
</center>
<center>
<form action="ActionFastWithdraw">
<table border='0'> 
<tr>
<td><br></td>
</tr>

<tr>
<td></td>
<td>
<input type="submit"  name="withdrawAmount" value="10000" class="button"/>
</td>
</tr>
</table>
<%		request.getRequestDispatcher("withdrawDisplay.jsp").include(
		request, response);
 %>

</form>
</center>

</body>
</html>