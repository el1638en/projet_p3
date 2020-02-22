<%@ include file="/WEB-INF/views/header.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>recherche</title>
    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../css/starter-template.css" rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<p>Rechercher un membre:</p>
<form:form method="POST" action="searchMember" modelAttribute="searchMember">
    <form:input path="name" type="text" name="name" id="name" class="form-control" placeholder="Name"
                autofocus="true" required="true"/>
    <form:input path="mailAdress" type="text" name="mailAdress" id="mailAdress" class="form-control" placeholder="Mail"
                autofocus="true" required="true"/>
    <form:button type="submit">Rechercher</form:button>
</form:form>
<c:if test = "${findMemberResult == true}">
    <p>R&eacute;sultats de votre recherche:</p>
        <ul>
            <li>${memberFind.name}</li>
            <li>${memberFind.mailAdress}</li>
            <li>${memberFind.firstName}</li>
            <li>${memberFind.adress}</li>
            <li>${memberFind.tel}</li>
            <li><a href="selectMember/${memberFind.id}">Choisir ce membre</a></li>
        </ul>
</c:if>
</body>
</html>