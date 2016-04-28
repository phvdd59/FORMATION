<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- sessionQ.jsp -->
<%
if (request.getParameter("nom") != null){
	session.setAttribute("nomEleve",request.getParameter("nom"));
	session.setAttribute("nbBonneReponse",new Integer(0));
	session.setAttribute("numQuestion",new Integer(1));
} else {
	if (session.getAttribute("nb1") != null){
		int n1=((Integer) session.getAttribute("nb1")).intValue(); 
		int n2=((Integer) session.getAttribute("nb2")).intValue();
		int essai=Integer.parceInt(request.getParameter("essai"));
		if (essai == n1*n2){
			int nbr = ((Integer) session.getAttribute("nbBonneReponse")).intValue();
			session.setAttribute("nbBonneReponse",new Integer(nbr+1));
		}
		int nq=((Integer) session.getAttribute("numQuestion")).intValue();
		session.setAttribute("numQuestion",new Integer(nq+1));
	}
}
%>
Eleve : <%= session.getAttribute("nomEleve") %> <br/>
Nombre de Bonne réponse : <%= session.getAttribute("nbBonneReponse") %><br/>
<% 
	session.setAttribute("nomEleve",session.getAttribute("nomEleve"));
	int nq=((Integer) session.getAttribute("numQuestion")).intValue();
	if (nq <= 3) {
		int n1=(int) Math.round(Math.random()*9+1); 
		int n2=(int) Math.round(Math.random()*9+1);
		session.setAttribute("nb1",new Integer(n1));
		session.setAttribute("nb2",new Integer(n2));
		%>
		<form method="get" action="sessionQ.jsp">
			question <%= nq %> : &nbsp<%= n1 %> * <%= n2 %><br/>
			<input type="text" name="essai" />
			<br/>
			<input type="submit" value="OK" />
		</form>
		<% 
	} else {
		session.setAttribute("nb1",new Integer(0));
		session.setAttribute("nb2",new Integer(1));
		%>
		<jsp:forward page="sessionR.jsp"/>
		<%
	}
%>
</body>
</html>
