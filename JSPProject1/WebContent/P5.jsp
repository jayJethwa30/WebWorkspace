<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>This is Page 5</h1>
	<hr>
	User is <%=request.getParameter("user") %><br>
	Admin Email is <%=request.getParameter("adminemail") %><br>
	<hr>
	<h1>Page 5 is ended</h1>
</body>
</html>