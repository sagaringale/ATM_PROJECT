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
	  
	  var currentPin=document.amountForm.currentPin.value;
	  var newPin=document.amountForm.newPin.value;
	  var newPin1=document.amountForm.newPin1.value;
	  if(currentPin==""){
		  
		  alert("please enter  currentPin ");
		  
		  return false;
		  
	  }
	  
if(newPin==""){
		  
		  alert("please enter  newPin ");
		  return false;
		  
	  }
if(newPin1==""){
	  
	  alert("please enter  Confirm Pin ");
	  return false;
	  
}
	  

	  if(isNaN(currentPin)){
		  
		  
		  alert(" Accounnt Number should be in Digits ");
		  
		  return false;
		  
	  }
if(isNaN(newPin)){
		  
		  
		  alert(" newPin  should be in Digits ");
		  return false;
		  
	  }
if(isNaN(newPin1)){
	  
	  
	  alert(" Confirm Pin should be in Digits ");
	  return false;
	  
}
if(currentPin==newPin){
	  
	  alert("please enter  currentPin and newPin different ");
	  
	  return false;
	  
}


	  if(currentPin!=5){
		  
		  alert(" currentPin  should be 5 digits ");
	
		  return false;
		  
	  }
if( newPin!=5){
		  
		  alert(" newPin should be 5 digits ");
		  return false;
		  
	  }
if( newPin1!=5){
	  
	  alert(" Confirm Pin should be 5 digits ");
	  return false;
	  
}


return true;
  }

</script>
</head>
<body>
<center>

<form action="ActionChangePin"  name="amountForm" onsubmit=" return  amountValidate()" method="get">

<table border='0'> 
<tr><td><% HttpSession session1=request.getSession(false);
if(session1!=null){
	request.getRequestDispatcher("withdrawDisplay.jsp").include(request, response);

}else{
	out.print("Please login first");
	request.getRequestDispatcher("Login.jsp").include(request, response);
}

	
	%>

</td>
</tr>


<tr>
<td><h1>Change </h1></td>
<td><h1>password</h1></td>
</tr>
 <tr>  

   <td><LABEL for="currentPin">Enter current Pin:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="password" id="currentPin" name="currentPin"><br/></td>  

 </tr>  
 <tr>  

   <td><LABEL for="newPin">Enter New Pin:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="password" id="newPin" name="newPin" ><br/></td>  

 </tr>
 <tr>  

   <td><LABEL for="newPin1">Confirm New Pin:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="password" id="newPin1" name="newPin1"><br/></td>  

 </tr>  
   
<tr>
<td><br></td>
</tr>

<tr>
<td></td>
<td>
<input type="submit" name="ChangePin" value="ChangePin" class="button" />
</td>
</tr>



</table>

</form>
</center>
</body>

</html>