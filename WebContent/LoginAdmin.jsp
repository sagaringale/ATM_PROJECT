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
<center>


<table border='0'> 
 <tr><th> <h1> Select Operation</h1><th></tr>
 <tr>  

   <td><form action="ActionAdminOperation">

<input type="submit" name="operationType" value="newCustomer"   class="button"/>
</form>
<br><br>
   </td>
   <td><br></td>  
   <td>
<form action="ActionAdminOperation">

<input type="submit" name="operationType" value="addBranchDetails"  class="button" />
</form>

<br>

<br/></td>  

 </tr>  
 <tr>  

   <td><form action="ActionAdminOperation">

<input type="submit" name="operationType" value="updateCustomer"   class="button"/>
</form>
<br><br>
   </td>
   <td><br></td>  
   <td>
<form action="ActionAdminOperation">

<input type="submit" name="operationType" value="deleteCustomer"  class="button" />
</form>

<br>

<br/></td>  

 </tr>  

</table>
</center>
<%		request.getRequestDispatcher("exitButton.jsp").include(
		request, response);
 %>

</body>
</html>