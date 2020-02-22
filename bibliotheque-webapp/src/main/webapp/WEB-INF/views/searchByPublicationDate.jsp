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
<p>Rechercher une oeuvre par Date:</p>
<form:form method="POST" action="searchByPublicationDate" modelAttribute="searchWorkByDate">
    <form:input path="publicationDate" type="text" name="publicationDate" id="publicationDate" class="form-control"
                placeholder="Date"
                autofocus="true" required="true"/>
    <form:button type="submit">Rechercher</form:button>
</form:form>
<c:if test="${findResult == true}">
    <p>R&eacute;sultats de votre recherche:</p>
    <c:forEach items="${listWorks}" var="work">
        <ul>
            <li>${work.title}</li>
            <li>${work.bookDescription}</li>
            <li><a href="borrow/${work.id}">Emprunter ce livre</a></li>
        </ul>
    </c:forEach>
</c:if>
</body>
</html>