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
	<jsp:useBean id="emp" class="com.lti.bean.Employee" scope="request"/>
	<h2>Aid : <jsp:getProperty name="emp" property="id"/><br>
	First Name : <jsp:getProperty name="emp" property="fname"/><br>
	Last Name : <jsp:getProperty name="emp" property="iname"/><br>
	DOJ : <jsp:getProperty name="emp" property="doj"/><br>
	Department : <jsp:getProperty name="emp" property="dept"/><br>
	</h2>
	<a href="index.html">Home</a>
</body>
</html>