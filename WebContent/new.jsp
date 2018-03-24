<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*"  import="java.io.*"%>

<html>
<body background="images/26.jpg">
<head>
<title>Welcome</title>

<%
try
{
    
 int log_ses_id=(Integer)session.getAttribute("ses_id");
// out.println("Logout session:"+log_ses_id);

	 session.invalidate();
//	 out.println("Logout session after destroying:"+log_ses_id);
 
%>
		<script language="javascript">;
		 alert("Logout Done Successfully");
     		</script>

  <center>
<br><br> 
<h3><b>Click on sign in to Re-Login</b></h3>
<br>
<a href="login.html"><h1><b>Sign In</b></h1></a>
</center>
<%
}

	catch(Exception e)
	{
                out.print(e);
		out.print("in Error catch");
	}
	
%>

</head>
</body>
</html>
	
