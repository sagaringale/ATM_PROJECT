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

  function adminValidate(){
	  
	  var userName=document.adminForm.userName.value;
	  var password=document.adminForm.password.value;
	  
	  if(userName==""){
		  
		  alert("please enter userName ");
		  //userName.focus();
		  return false;
		  
	  }
if(password==""){
		  
		  alert("please enter  password  ");
		  //password.focus();
		  return false;
		  
	  }
	  

	 	  return true;
  }
  </script>

  </head>

<body>
<center>

<form action="AdminLoginAction" name="adminForm" onsubmit=" return  adminValidate()" method="get">

<table border='0'> 
<tr>
<td><h1>Welcome to </h1></td>
<td><h1>WWW.ATM</h1></td>
</tr>
 <tr>  

   <td><LABEL for="userName">Enter UserName:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="text" id="userName" name="userName"><br/></td>  

 </tr>  
 <tr>  

   <td><LABEL for="password">Enter Password:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="password" id="password" name="password"><br/></td>  

 </tr>  
<tr>
<td><br></td>
</tr>

<tr>
<td></td>
<td>
<input type="submit"  value="Login"  class="button"  />
</td>
</tr>



</table>

</form>
</center>


</body>
</html>