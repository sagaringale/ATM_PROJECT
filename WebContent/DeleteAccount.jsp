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

  function amountValidate(){
	  
	  var customerId=document.amountForm.customerId.value;
	  
	  
	  if(customerId==""){
		  
		  alert("please enter  customerId");
		  
		  return false;
		  
	  }
	  

	  if(isNaN(customerId)){
		  
		  
		  alert(" customerId should be in Digits ");
		  
		  return false;
		  
	  }

	  if(customerId.lenght>5  ){
		  
		  alert(" customerId should be 5 digits ");
		  amount.focus();
		  return false;
		  
	  }
if( customerId.length!=5){
		  
		  alert(" customerId should be 5 digits ");
		  return false;
		  
	  }
	  return true;
  }

</script>
</head>
<body>
<center>

<form action="ActionCustDelete" name="amountForm" onsubmit=" return  amountValidate()" method="get">

<table border='0'> 
<tr>
<td>

 </td>
 </tr>

<tr>
<td>
<h3>Enter Account Number  you</h3>

 </td>
 <td>
 <h3>want to Delete</h3>
 </td>
 </tr>

 <tr>  

   <td><LABEL for="customerId">Enter Account Number:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="text" id="customerId" name="customerId"></td>  

 </tr>  


<tr>
<td>

</td>
</tr>

<tr>
<td></td>
<td>
<input type="submit" name="DeleteAccount" value="DeleteAccount"  />
</td>
</tr>

</table>
<%		request.getRequestDispatcher("withdrawFastDisplay.jsp").include(
		request, response);
 %>

</form>
</center>

</body>
</html>