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
	  
	  var withdrawAmount=document.amountForm.withdrawAmount.value;
  if(withdrawAmount==""){
		  
		  alert("please enter  withdrawAmount");
		  
		  return false;
		  
	  }
  if (withdrawAmount<0)
  {
	  
	  alert("please enter valid withdrawAmount");
	  
	  return false;
	  
  }
  if (withdrawAmount==0)
  {
	  
	  alert("please enter valid withdrawAmount");
	  
	  return false;
	  
  }

  if(isNaN(withdrawAmount)){
	  
	  
	  alert("withdrawAmount   should be in Digits ");
	  
	  return false;
	  
  }
  /*  if ((event.keyCode > 48 || event.keyCode < 57)) 
  {
	  alert("WithdrawAmount is in Number");
         event.returnValue = false;
        
  } */
  return true;
  }
  </script>
</head>
<body>
<center>

<form action="ActionWithdraw" name="amountForm" onsubmit=" return  customerValidate()" onclick="phonenumber(pno)" method="get">

<table border='0'> 
<tr>
<td><h2> Enter amount you want</h2></td>
<td><h2>to withdraw</h2></td>
</tr>
 
<tr>
<td></td>
<td></td>
</tr>
 <tr>  

   <td><LABEL for="withdrawAmount">Enter Amount:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="text" id="withdrawAmount" name="withdrawAmount" ><br/></td>  

 </tr>  
<tr>
<td><br></td>
<td><br>
</td>
</tr>
<tr>
<td></td>
<td>
 <input type="submit" name="name" value="WithdrawAmount"  />
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