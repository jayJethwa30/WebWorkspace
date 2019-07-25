<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.lti.bean.Order"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Total Bill</h1>
	<% Order ob=(Order) session.getAttribute("myorder"); %><br>
	Pid : <%=ob.getPid()%><br>
	Product Name : <%=ob.getPname()%><br>
	Price : <%=ob.getPrice()%><br>
	Quantity : <%=ob.getQuantity()%><br>
	Bill : <%=ob.getBill()%><br>
	<hr>
	<h1>Total Bill using EL :</h1>
	Pid : ${sessionScope.myorder.pid}<br>
	Pname  : ${sessionScope.myorder.pname}<br>
	Price  : ${sessionScope.myorder.price}<br>
	Quantity  : ${sessionScope.myorder.quantity}<br>
	Bill : ${sessionScope.myorder.bill }
	<hr>
	
	<jsp:useBean id="myorder" class="com.lti.bean.Order" scope="session"></jsp:useBean>
	<h1>Total Bill using JSP tag :</h1>
	Pid : <jsp:getProperty name="myorder" property="pid" /><br>
	Pname  : <jsp:getProperty name="myorder" property="pname"/><br>
	Price  : <jsp:getProperty name="myorder" property="price"/><br>
	Quantity  : <jsp:getProperty name="myorder" property="quantity"/><br>
	Bill : <jsp:getProperty name="myorder" property="bill"/>
	<hr>
	
	<a href="Discount.jsp">Apply Discount</a>
</body>
</html>