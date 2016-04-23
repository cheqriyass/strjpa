<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html-el" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription Form</title>
</head>
<body>

<p><bean:message key="message.formHeader"/></p>


<html:form action="/sinscrir" method="post">
    Nom: <html:text property="nom"/><br/>
    Prenom: <html:text property="prenom"/><br/>
    email: <html:text property="email"/><br/>
    Password: <html:text property="password"/><br/>
    N°Permis: <html:text property="numPermis"/><br/>

    <html:submit value="Submit" />
</html:form>
</body>
</html>
