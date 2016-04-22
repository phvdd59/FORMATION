<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- sessionR.jsp -->
<% 
	int nbr = ((Integer) session.getAttribute("nbBonneReponse")).intValue();
	String nom=(String) session.getAttribute("nomEleve");
	session.setAttribute("nomEleve",nom);
	session.setAttribute("nbBonneReponse",new Integer(0));
	session.setAttribute("numQuestion",new Integer(1));
	session.removeAttribute("nb1");
	session.removeAttribute("nb2");
%>
Eleve <%= nom %> <br/>
Nombre de bonnes réponses <%= nbr %><br/>
	voulez vous un Autre exercice pour ?<br/>
<a href="http://localhost:8080/ProjectJSP/jsp/sessionQ.jsp">"<%= nom %>"</a><br/>
<a href="../html/sessionI.html"> un Autre Eleve</a>


</body>
</html>