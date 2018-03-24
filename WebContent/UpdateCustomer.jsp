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
	  
  var customerId=document.amountForm.customerId.value;
  var pno=document.amountForm.contactNumber.value;
  var customerAddress=document.amountForm.customerAddress.value;  
	  
	  if(customerId==""){
		  
		  alert("please enter  Account Number");
		  
		  return false;
		  
	  }
	  

	  if(isNaN(customerId)){
		  
		  
		  alert("  Account Number should be in Digits ");
		  
		  return false;
		  
	  }
	  if(customerAddress==""){
		  
		  alert("please enter  Customer Address ");
		  
		  return false;
		  
	      }
	  if(pno==""){
		  
		  alert("please enter  Contact Number");
		  
		  return false;
		  
	    }
	  if(customerId.lenght>5  ){
		  
		  alert(" customerId should be 5 digits ");
		  amount.focus();
		  return false;
		  
	  }
if( customerId.length<5){
		  
		  alert(" customerId should be 5 digits ");
		  return false;
		  
	  }

	  return true;
  }

</script>
</head>
<body>
<center>
<form action="ActionUpdate" name="amountForm" onsubmit=" return  customerValidate()"  method="get">
<table border='0'> 
<tr>
<td>
<h3>Enter Account Number you want to Update</h3>
</td>
</tr>

 <tr>  

   <td><LABEL for="customerId">Account Number:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="text" id="customerId" name="customerId"><br/></td>  

 </tr>  
<tr>
<td>
<h3>Enter Updated Account Information </h3><br><br>
 </td></tr>
<!--  <tr>  

   <td><LABEL for="customerAddress">Enter Account Address:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="text" id="customerAddress" name="customerAddress"><br/></td>  

 </tr>
 -->
 <tr>
 <td><LABEL for="customerAddress">Enter Account Address:<sup style="color:#F00">*</sup> </LABEL></td>  
<td>
<textarea id="customerAddress"  name="customerAddress" rows="2" cols="20"></textarea> 
</td>
</tr>
   
<tr>  

   <td><LABEL for="contactNumber">Enter Contact Number:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="text" id="contactNumber" name="contactNumber"><br/></td>  

 </tr>  
<tr>
<td><br><br></td>
<td>
<input type="submit" name="UpdateAccount" value="UpdateAccount"  />
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