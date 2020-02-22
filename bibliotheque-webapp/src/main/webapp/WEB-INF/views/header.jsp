<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"%>


<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>header menu</title>
    <!-- Bootstrap core CSS
    <link href="css/bootstrap.min.css" rel="stylesheet">-->
    <!-- Custom styles for this template
    <link href="css/starter-template.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/WEB-INF/views/login.jsp">Bibliothèque</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/WEB-INF/views/login.jsp">Home</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="menuDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Rechercher une oeuvre
                    </a>
                    <div class="dropdown-menu" aria-labelledby="menuDropdown">
                        <a class="dropdown-item" href="searchWork">Par auteur</a>
                        <br>
                        <a class="dropdown-item" href="searchWorkByDate">Par année de publication</a>
                        <a class="dropdown-item" href="searchWorkByTitle">Par titre</a>
                    </div>
                </li>
                <li><a href="searchMemberBorrow">Rechercher Membre</a></li>
                <li><a href="/moncompte">Mon compte</a></li>


            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<br>
<br>
<br>
<br>
<br>