<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Account Data</h1>
	<jsp:useBean id="myacc" class="com.lti.bean.Account" scope="request"/>
	<h2>Aid : <jsp:getProperty name="myacc" property="aid"/><br>
	Name : <jsp:getProperty name="myacc" property="aname"/><br>
	DOB : <jsp:getProperty name="myacc" property="dob"/><br>
	Balance is : Rs. <jsp:getProperty name="myacc" property="balance"/><br>
	</h2>
	<a href="index.html">Home</a>
</body>
</html>