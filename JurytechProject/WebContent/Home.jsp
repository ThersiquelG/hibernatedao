<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription worked</title>
</head>
<body>

<center>
		<h2>Home Page</h2>
	</center>
	Welcome
	<%=request.getParameter("prenom")%>
	<!-- Refer to the video to understand how this works -->
	<div style="text-align: right">
		<a href="LogoutServlet">Logout</a>
	</div>

</body>
</html>