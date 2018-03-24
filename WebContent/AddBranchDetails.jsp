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
	  
	  var branchId=document.amountForm.branchId.value;
	  var branchName=document.amountForm.branchName.value;
	  var branchAddress=document.amountForm.branchAddress.value;
	   if(branchId==""){
		  
		  alert("please enter  branchId ");
		  
		  return false;
		  
	  }
if(branchName==""){
		  
		  alert("please enter  branchName ");
		  return false;
		  
	  }
	  
if(branchAddress==""){
	  
	  alert("please enter  branchAddress ");
	  return false;
	  
}

	  if(isNaN(branchId)){
		  
		  
		  alert(" branchId should be in Digits ");
		  
		  return false;
		  
	  }

	  return true;
  }

</script>
</head>
<body>
<center>

<h1>Add Branch Details</h1>
<form action="ActionBranch" name="amountForm" onsubmit=" return  amountValidate()" method="get">

<table border='0'> 
 <tr>  

   <td><LABEL for="branchId">Enter Branch Id:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="text" id="branchId" name="branchId"><br/></td>  

 </tr>  
 <tr>  

   <td><LABEL for="branchName">Enter Branch Name:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="text" id="branchName" name="branchName"><br/></td>  

 </tr>  
<tr>  

   <td><LABEL for="branchAddress">Enter Branch Address:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="text" id="branchAddress" name="branchAddress"><br/></td>  

</tr>
<tr>
<td>
<br>
</td>
</tr>

<tr>
<td></td>
<td>
<input type="submit"  value="ADD"  />
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