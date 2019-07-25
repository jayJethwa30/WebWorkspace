<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.Date"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>This is JSP</h1>
	<font color="red" size="5">
		Today's Date is : <%= new Date()%>
	</font>
	<hr>
	<h1>Calling MyServlet</h1>
	<a href="MyServlet.view">Call Servlet</a>
</body>
</html>