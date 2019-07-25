<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.lti.bean.LoginUser;"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type " content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>This is Bank.jsp</h1>
	<h2>User is <%=request.getParameter("user") %></h2>
	<h2>User using EL is ${param.user}</h2>
	<hr>
	<h2>User is <%LoginUser userdetails=(LoginUser)request.getAttribute("userdetails"); %> 
		<%=userdetails.getUsername() %></h2>
		<h2>Email is <%=userdetails.getEmail() %></h2>
	<hr>
	User is EL ${requestScope.userdetails.username} <br>
	Email is EL ${requestScope.userdetails.email}
</body>
</html>