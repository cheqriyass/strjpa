<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html-el" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<html:form action="/signup" method="post">
    first name: <html:text property="firstname"  /><br/>
    last name: <html:text property="lastname" /><br/>
    username: <html:text property="username" /><br/>
    password: <html:password property="password" value=""/><br/>
    password confirmation: <html:password property="passwordConfirmation" value=""/><br/>
    sex: <html:radio property="sex" value="Male"/>
    <html:radio property="sex" value="Female"/><br/>
    field:
    <html:select property="field">
        <html:option value="GI" />
        <html:option value="GRT" />
        <html:option value="GIL" />
        <html:option value="GE" />
    </html:select><br/>
    <html:submit value="SignUp"/>

    <html:errors/>
</html:form>
</body>
</html>
