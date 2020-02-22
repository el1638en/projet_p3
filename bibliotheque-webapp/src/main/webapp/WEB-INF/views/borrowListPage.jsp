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

<p>Liste des emprunts du membre selectionn&eacute;:
</p>
<c:if test = "${findResult == true}">
    <c:forEach items="${borrowList}" var="borrow">
        <ul>
            <li>Statut de l'emprunt: ${borrow.status}</li>
            <li>Date de d&eacute;but de l'emprunt: ${borrow.startBorrowDate}</li>
            <li>Date de fin de l'emprunt: ${borrow.endBorrowDate}</li>
            <li>Prolong&eacute; : ${borrow.extended}</li>
            <li>Titre du livre: ${borrow.workTitle}</li>
        </ul>
    </c:forEach>
</c:if>
</body>
</html>
