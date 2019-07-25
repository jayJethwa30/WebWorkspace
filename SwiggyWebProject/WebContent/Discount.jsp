<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.lti.bean.Order"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	Cookie c[]=request.getCookies();
	String bg="";
	if(c!=null) {
		for(Cookie myc:c) {
			out.println("Key : "+myc.getName()+", Value : "+myc.getValue()+"<br>");
			if(myc.getName().equals("bgc")) {
				bg=myc.getValue();
			}
		}
	}
%>
<body bgcolor=<%=bg%>>
	<% Order ob=(Order) session.getAttribute("myorder"); %>
	<font color="red" size="6">
		<% if(ob.getBill()>=5000.00) {
			out.println("Flat 20% Discount available :"+(ob.getBill()*0.2));
			out.println("<br>Your final bill amount after discount is : "+(ob.getBill()-(ob.getBill()*0.2)));
		}
		else {
			out.println("Better Luck Next Time!!");
		}
		%>
		<br>
		<% 
		if(session.isNew()) {
			out.println("NEW Session");
		}
		else {
			out.println("OLD Session");
		}
		%>
		<hr>
		<%session.setMaxInactiveInterval(2*60*60*1000); %>
		The session id is session.getId()...<%=session.getId() %><br>
		To expire the session method is session.invalidate()...<% session.invalidate(); %>
		<hr>
	</font>
</body>
</html>