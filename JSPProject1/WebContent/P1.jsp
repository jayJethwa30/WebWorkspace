<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Declaration Tags
	<%!
		int res;
		public int add(int a, int b) {
			return a+b;
		}
	%>
	<hr>
	Scriplets
	<%
		Date today=new Date();
	%>
	<hr>
	Expression Tags
	<%= today %>
	<hr>
	Calling Method
	<% res=add(4, 5); %>
	<hr>
	Printing Result : 
	<%=res %>
</body>
</html>