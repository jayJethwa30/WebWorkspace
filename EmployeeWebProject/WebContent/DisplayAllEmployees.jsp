<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.lti.bean.*, java.util.List"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>The Following is the list of all the Employees : </h1>
	<%  
	List<Employee> mylist=(List<Employee>)application.getAttribute("emplist"); 
	for(Employee e:mylist) {
		out.println("ID : "+e.getId());
		out.println("First Name : "+e.getFname());
		out.println("Last Name : "+e.getIname());
		out.println("Date Of Joining : "+e.getDoj());
		out.println("Department : "+e.getDept());
		%><hr><%
	}
	%>
	<a href="index.html">Home</a>
</body>
</html>