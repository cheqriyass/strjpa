<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-nested" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>inscription Succes</title>
</head>
<body>
Bonjour
last name: <bean:write name="student" property="lastname"/>
first name: <bean:write name="student" property="firstname"/>
</body>
</html>
