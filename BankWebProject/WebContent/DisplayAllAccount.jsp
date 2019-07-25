<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.lti.bean.*, java.util.List"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of all accounts : </h1>
	<%  
	List<Account> mylist=(List<Account>)application.getAttribute("acclist"); 
	for(Account o:mylist) {
		out.println("Aid is "+o.getAid());
		out.println(", Account Holder is "+o.getAname());
		out.println(", DOB is "+o.getDob());
		out.println(", Balance is "+o.getBalance());
		%><hr><%
	}
	%>
	<a href="index.html">Home</a>
</body>
</html>