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
	  var customerName=document.amountForm.customerName.value;
	  var pno=document.amountForm.customerContactNumber.value;
	  var customerEmail=document.amountForm.customerEmail.value;      
	  var customerAddress=document.amountForm.customerAddress.value;  
	  var dd=document.amountForm.dd.value; 
	  var mmm=document.amountForm.mmm.value; 
	  var yyyy=document.amountForm.yyyy.value; 
	  
	  
	  if(customerId==""){
		  
		  alert("please enter  Customer Id ");
		  
		  return false;
		  
	  }
  if(customerId.lenght<5){
		  
		  alert(" customerId  should be 5 digits ");
		 
		  return false;
		  
	  }
  if(customerId.length>5){
	  
	  alert(" customerId  should be 5 digits ");
	  return false;
	  
  }
  if (event.customerName < 65  || event.customerName > 91) 
  {
	  alert("Customer Name is");
         event.returnValue = false;
        
  }
  if(customerName==""){
		  
		  alert("please enter  customer Name ");
		  return false;
		  
	  }
if(dd==""){
	  
	  alert("please select  Date ");
	  return false;
	  
}
if(mmm==""){
	  
	  alert("please select Month ");
	  return false;
	  
}
if(yyyy==""){
	  
	  alert("please select Year ");
	  return false;
	  
}
	  

	  if(isNaN(customerId)){
		  
		  
		  alert("Customer Id  should be in Digits ");
		  
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
if(pno.length != 10) {
    window.alert("Phone number must be 10 digits.");
    return false;
}

if(isNaN(pno)){
	  
	  
	  alert("Contact Number  should be in Digits ");
	  
	  return false;
	  
}
if(customerEmail==""){
	  
	  alert("please enter  Customer Email ");
	  
	  return false;
	  
}

/* function phonenumber(pno)   
{   
  var phoneno = /^\d{10}$/;   
  if((pno.match(phoneno))   
        {   
      return true;   
        }   
      else  
        {   
        alert("enter valid phone number");   
        return false;   
        }   
}   */


	
	  return true;
  }
  
</script>
</head>
<body>
<center>
<h1>New Customer Details</h1>

<form action="ActionNewCustomer" name="amountForm" onsubmit=" return  customerValidate()" onclick="phonenumber(pno)" method="get">

<table border='0'> 
 <tr>  

   <td><LABEL for="customerId">Enter Id:<sup style="color:#F00">*</sup> </LABEL></td>  

          <td><INPUT type="text" id="customerId" name="customerId"><br/></td>  

 </tr>  

    <!--    :<input type="text" name="customerId"/><br><br>  -->
<tr>
<td><LABEL for="customerName">Enter Name:<sup style="color:#F00">*</sup> </LABEL></td>  

<td>
<input type="text" name="customerName" id="customerName"/><br/>
</td>
</tr>
 <tr>  

   <td><LABEL for="customerDOB">Date of Birth:<sup style="color:#F00">*</sup> </LABEL></td>  
 
 
   <td>   

   <select id="dd" name="dd">  

         <option value="dd">DD</option>  

         <script type="text/javascript">  

    for(var i=1;i<32;i++)  

     document.write("<option value='"+i+"'>" + i+"</option> ");  

    </script>  

         </select>  

                 </select>  

                 <select id="mmm" name="mmm">  

         <option value="mmm">MMM</option>  

          <option value="1">JAN</option>  

          <option value="2">FEB</option>  

          <option value="3">MAR </option>  

          <option value="4">APR</option>  

          <option value="5">MAY</option>  

          <option value="6">JUN</option>  

          <option value="7">JUL</option>  

          <option value="8">AUG</option>  

          <option value="9">SEP</option>  

          <option value="10">OCT</option>  

          <option value="11">NOV</option>  

          <option value="12">DEC</option>  


         </select>  

         <select id="yyyy" name="yyyy">  

            <option value="yyyy"selected>YYYY</option>  

         <script type="text/javascript">  

    var dt= new Date();  

    for(var i=1979;i<=dt.getFullYear();i++)  

     document.write("<option value='"+i+"'>" + i+"</option> ");  

   </script>  

   </select>  


   </td>  

 </tr> 
  <tr>
  <td><LABEL for="customerDOB">Gender:<sup style="color:#F00">*</sup> </LABEL></td> 
  <td>Male<INPUT type="radio" name="gender" value="male"><br></td> 
  <td>Female<INPUT type="radio" name="gender" value="female"><br/></td>  
  </tr>
<tr>
<td><LABEL for="customerAddress">Enter Address:<sup style="color:#F00">*</sup> </LABEL></td>  
<td>
<textarea id="customerAddress"  name="customerAddress" rows="2" cols="20"></textarea> 
</td>
</tr>

<!-- <tr>
<td><LABEL for="customerDOB">Enter DOB:<sup style="color:#F00">*</sup> </LABEL></td>  
<td>
<input type="text" name="customerDOB" id="customerDOB"/><br/>
</td>
</tr>
 --> 

<tr>
<td><LABEL for="customerContactNumber">Enter Contact No:<sup style="color:#F00">*</sup> </LABEL></td>  
<td>
<input type="text" name="customerContactNumber" id="customerContactNumber"/><br/>
</td>
</tr>

<tr>
<td><LABEL for="customerEmail">Enter Email Id:<sup style="color:#F00">*</sup> </LABEL></td>  

<td>
<input type="text" name="customerEmail" id="customerEmail"/><br/>
</td>
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