<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	import="com.lti.bean.Counter1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>session scope</h1>
	Generate object of Counter1 in session scope use jsp:useBean<br>
	<jsp:useBean id="cob" class="com.lti.bean.Counter1" scope="session"></jsp:useBean>
	id = Object Variable name or attribute name 
	class = Object is of which class
	<hr>
	To invoke setter method for count property use jsp:setProperty<br>
	<jsp:setProperty property="count" name="cob" />
	name = object name
	property = count property in class
	value = value for the count<br> 
	<hr>
	To invoke getter method for count property use jsp:getProperty<br>
	<jsp:getProperty property="count" name="cob"/>		
</body>
</html>