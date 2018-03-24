<%-- <%@page import="com.sun.java_cup.internal.runtime.Scanner"%> --%>
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


<script type="text/javascript">
  function customerValidate(){
	  
	  var depositAmount=document.amountForm.depositAmount.value;
  if(depositAmount==""){
		  
		  alert("please enter  depositAmount");
		  
		  return false;
		  
	  }
  if (depositAmount<0)
  {
	  
	  alert("please enter valid depositAmount");
	  
	  return false;
	  
  }
  if (depositAmount==0)
  {
	  
	  alert("please enter valid depositAmount");
	  
	  return false;
	  
  }

  if(isNaN(depositAmount)){
	  
	  
	  alert("depositAmount   should be in Digits ");
	  
	  return false;
	  
  }	  
  /* if ((event.keyCode < 48 || event.keyCode > 57)) 
  {
	  alert("depositAmount is in Number");
         return false;
        
  } */
/*   if (event.keyCode!=46 ) 
  {
	  alert("depositAmount is in Number");
         return false;
        
  } */

  return true;
  }
  </script>

</head>
<body>
<form action="Operation" name="amountForm" onsubmit=" return  customerValidate()" method="get">
<h1>Enter Amount you want to Deposit</h1>
<!-- Enter Account Number:<input type="text" name="accountNumber"/><br><br>  -->
Enter Amount :<input type="text" name="depositAmount"/><br><br> 
<input type="submit" name="DepositAmount" value="DepositAmount"  />
</form>
<%		request.getRequestDispatcher("withdrawDisplay.jsp").include(
		request, response);
 %>

</body>
</html>