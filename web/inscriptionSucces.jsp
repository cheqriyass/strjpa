<%@ page import="entities.Exercice.Arret" %>
<%@ page import="entities.Exercice.Annonce" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-nested" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>inscription Succes</title>
</head>
<body>
Bonjour<br/>
last name: <bean:write name="trs" property="nom"/><br/>
first name: <bean:write name="trs" property="numPermis"/><br/>
<%
    out.println("Liste d'Annonces: ");
    List<Annonce> list = (List<Annonce>)request.getSession().getAttribute("ann");
    for(Annonce a : list){
        out.println(a.getId());
    }
%>

</body>
</html>
