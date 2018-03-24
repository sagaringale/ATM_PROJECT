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
<h1> Select Operation</h1> <br><br>

<table border='0'> 
 <tr>  

   <td><form action="ActionWithdrawType">

<input type="submit" name="operationType" value="getCash"   class="button"/>
</form>
<br><br>
   </td>
   <td><br></td>  
   <td>
 </tr>  
<tr>
<td><form action="ActionWithdrawType" >

<input type="submit" name="operationType" value="fastCash" class="button" />
</form>
</td>
</tr> 
 </table>
 <%		request.getRequestDispatcher("withdrawDisplay.jsp").include(
		request, response);
 %>
 
</center>

</body>
</html>