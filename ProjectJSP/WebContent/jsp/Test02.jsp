<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	<div style="width:700px;border: solid;text-align: center;">
		<h1>Test02 jsp</h1>
			<% 	
				for (int i=0;i<5;i++){
			%>
					<h3><%= i %> salut</h3>
			<% 	
				}
			%>		
	</div>
	</body>
</html>
