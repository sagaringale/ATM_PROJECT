<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.lower-right-button1{
    position:absolute;
    bottom: 0;
    right:0;
}
.lower-right-button1{
    position:absolute;
    margin-right:10;
    margin-bottom: 10;

}

.button{
 background-color:white;
    width: 10em;  height: 2em;
}
hr {color: sienna;}
p {margin-left: 20px;}
body {background-image: url("images/atm-pin1.png");}

</style>

</head>
<body>

<form action="ActionCommonButtons">
<input type="submit" name="name" value="Menu" class="lower-right-button" class="button" />

</form>
<form action="ActionCommonButtons">
<input type="submit" name="name" value="Exit" class="lower-right-button" style="right: 500 px" class="button"/>
</form>

</body>
</html>