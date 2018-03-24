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
body {background-image: url("images/ATM.jpg");}
</style>

<script type="text/javascript">

  function amountValidate(){
	  
	  var amount=document.amountForm.accountNumber.value;
	  var accountPin=document.amountForm.accountPin.value;
	  
	  if(amount==""){
		  
		  alert("please enter  Accounnt Number ");
		  
		  return false;
		  
	  }
if(accountPin==""){
		  
		  alert("please enter  Accounnt  Pin ");
		  return false;
		  
	  }
	  

	  if(isNaN(amount)){
		  
		  
		  alert(" Accounnt Number should be in Digits ");
		  
		  return false;
		  
	  }
if(isNaN(accountPin)){
		  
		  
		  alert(" Accounnt Pin should be in Digits ");
		  return false;
		  
	  }

	  if(amount.lenght>5 || amount.length<5 ){
		  
		  alert(" Accounnt Number  should be 5 digits ");
		  amount.focus();
		  return false;
		  
	  }
if( accountPin.lenght>5||accountPin.length<5){
		  
		  alert(" Accounnt Pin should be 5 digits ");
		  return false;
		  
	  }
	  return true;
  }

</script>
</head>
<body>
<center>

<form action="ActionCustomerLogin"  name="amountForm" onsubmit=" return  amountValidate()" method="get">

<table border='0'> 
<tr>
<td><h1>Welcome to </h1></td>
<td><h1>WWW.ATM</h1></td>
</tr>
 <tr>  

   <td><LABEL for="accountNumber">Enter AccountNumber:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="text" id="accountNumber" name="accountNumber"><br/></td>  

 </tr>  
 <tr>  

   <td><LABEL for="accountPin">Enter AccountPin:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="password" id="accountPin" name="accountPin"><br/></td>  

 </tr>  
<tr>
<td><br></td>
</tr>

<tr>
<td></td>
<td>
<input type="submit"  value="Login"  class="button" />
</td>
</tr>



</table>

</form>
</center>
</body>
</html> 