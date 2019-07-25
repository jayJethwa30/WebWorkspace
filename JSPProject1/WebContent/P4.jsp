<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>This is Page 4</h1>
	<hr>
	<%-- 
	<jsp:include page="P5.jsp">
		<jsp:param name="adminemail" value="admin@lntinfotech.com"></jsp:param>
	</jsp:include>
	--%>
	<jsp:forward page="P5.jsp">
		<jsp:param name="adminemail" value="admin@lntinfotech.com"></jsp:param>
		
	</jsp:forward>
	<hr>
	<h1>Page 4 Ended</h1>
</body>
</html>