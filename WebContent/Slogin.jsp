<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*"  import="java.io.*"%>

<html>
<head>
<title>sign up</title>
<%

String  fnm="",lnm="",uname="",pass="",pass2="",secques="",secans="",gend="",d_mon="",d_day="",d_year="";
int flag=0;
/*int d_day=0,d_year=0;*/
int u_id=0,prof_id=0;


       fnm=request.getParameter("fnm");
       lnm=request.getParameter("lnm");
       uname=request.getParameter("eid");
       pass=request.getParameter("pswd");
       pass2=request.getParameter("pswd2");	
       secques=request.getParameter("s1");
       secans=request.getParameter("secans");
       d_mon=request.getParameter("b_mon");
       /*d_day=Integer.parseInt(request.getParameter("b_day"));
       d_year=Integer.parseInt(request.getParameter("b_year"));*/

	d_day=request.getParameter("b_day");
       d_year=request.getParameter("b_year");
	gend=request.getParameter("gend");

       



%>

<%
String DB_URL="jdbc:mysql://localhost:3306/secure_cloud",DB_USER="root",DB_PASS="neha";
Connection con=null;
PreparedStatement pst=null,pst1=null,pst2=null,pst3=null;
ResultSet rs=null;

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
              if(con==null)
		{
			System.out.println("notconnected");
		}
		else
		{
			System.out.println("established");		
		}






pst=con.prepareStatement("select * from user");
rs=pst.executeQuery();


if(rs.next())
{
	




		if(uname.compareTo(rs.getString(2))==0)
	
		{
	
		
%>
			<script language="javascript">
			alert("Username already exist try with another username");
			window.location.replace("signup.html");
			</script>
<%
		}
	      else
		{
	       	
		pst2=con.prepareStatement("insert into user values(?,?,?)");
		
		pst2.setInt(1,0);
		pst2.setString(2,uname);
		pst2.setString(3,pass);
		pst2.executeUpdate();
	
	
		pst3=con.prepareStatement("select u_id from user where u_email='"+uname+"';");
		rs=pst3.executeQuery();
	        if(rs.next())
		 {
		   u_id=rs.getInt(1);
			if(u_id==0)
				u_id=1;
		
		 }

		out.println("uid is"+u_id);





pst1=con.prepareStatement("insert into profile values(?,?,?,?,?,?,?,?,?,?,?)");

pst1.setInt(1,0);
pst1.setInt(2,u_id);
pst1.setString(3,fnm);
pst1.setString(4,lnm);
pst1.setString(5,secques);
pst1.setString(6,secans);
pst1.setString(7,d_mon);
pst1.setString(8,d_day);
pst1.setString(9,d_year);
pst1.setString(10,gend);
pst1.setString(11,null);
pst1.executeUpdate();

}	
%>
		<script language="javascript">
			alert("Signup successful...relogin now");
			window.location.replace("login.html");
		</script>
<%

}
}				


catch(Exception e)
{
out.println("hello neha we r in signupcatch ");
out.print(e.getMessage());
}



%>
</head>
<body>
</body>
</html>
