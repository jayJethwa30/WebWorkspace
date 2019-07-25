<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EmployeeServlet" method="post">
		Enter Id : <input type="number" name="id" required><br>
		Enter First Name : <input type="text" name="fname" required><br>
		Enter Last Name : <input type="text" name="lname" required><br>
		Enter DOJ : <input type="text" name="doj" placeholder="dd-MM-yyyy" required><br>
		Enter Department Number : <input type="number" name="dept" required><br>
		<input type="submit" value="Add Employee">
	</form>
</body>
</html>