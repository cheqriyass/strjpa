<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Connexion</title>
    <style>
        .error-status{
            MARGIN-TOP: 5px;
            MARGIN-BOTTOM: 5px;
            display: block;
            COLOR: red

        }

        .error {
            COLOR: red
        }

        .status {
            color: #0066CC
        }
    </style>
</head>


<body>

    <html:link href="/strjpa/loadsignup.do">Sign Up</html:link><br/>
    <html:link href="/strjpa/client.do">Client Action</html:link><br/>
    <html:link href="/strjpa/InscriptionForm.jsp">Inscription</html:link>
<%--<html:form method="post" action="/login">--%>
    <%--<fieldset>--%>
        <%--<legend>Connexion</legend>--%>
        <%--<p><bean:message key="message.fromHeader"/></p>--%>
        <%--<html:text property="username" size="20" maxlength="20"/>--%>
        <%--<span class="error-status"><html:errors property="username"/></span>--%>
        <%--<br/>--%>

        <%--<html:password property="password" value="" size="20" maxlength="20"/>--%>
        <%--<span class="error-status"><html:errors property="password"/></span>--%>
        <%--<br/>--%>

        <%--<html:submit value="Connexion" />--%>
        <%--<br/>--%>

    <%--</fieldset>--%>
<%--</html:form>--%>

<%--<html:link href=""></html:link>--%>
</body>
</html>


<%--<form method="post" action="/strjpa/login.do">--%>
<%--<fieldset>--%>
<%--<legend>Connexion</legend>--%>
<%--<p>Vous pouvez vous connecter via ce formulaire.</p>--%>
<%--<p><bean:message key="message.hello" arg0="username"/></p>--%>
<%--<input type="text" name="username" value="" size="20" maxlength="60" />--%>
<%--<br />--%>

<%--<input type="password" name="password" value="" size="20" maxlength="20" />--%>
<%--<br />--%>

<%--<input type="submit" value="Connexion" />--%>
<%--<br />--%>
<%--<div>    <html:errors/> </div>--%>
<%--</fieldset>--%>
<%--</form>--%>