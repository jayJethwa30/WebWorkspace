<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EmployeeDeleteServlet" method="post">
		Enter Employee id to delete : <input type="number" name="id">
		<input type="submit" value="Delete">
	</form>
	
	<a href="DisplayAllEmployees.jsp">Display</a>
</body>
</html>