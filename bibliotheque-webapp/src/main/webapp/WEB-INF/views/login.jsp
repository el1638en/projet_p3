<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<head>
    <title>Welcome</title>
</head>
<body>
<div>
    <form:form method="post" action="login" modelAttribute="login">
        <h2 class="form-heading">Log in</h2>
        <h2>${message}</h2>
        <div class="form-group">
            <form:input path="username" name="username" id="username" type="text" class="form-control" placeholder="Username"
                        autofocus="true" required="true"/>
            <br/><br/>
            <form:input path="password" name="password" id="password" type="password" class="form-control" placeholder="Password" required="true"/>
            <br/><br/>
            <span>${error}</span>
            <form:button type="submit">Log In</form:button>
        </div>
    </form:form>
</div>
</body>
</html>