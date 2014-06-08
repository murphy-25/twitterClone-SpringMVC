<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Your Account</title>
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/resources/css/masterPage.css" rel="stylesheet" />
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Mr Blabber</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Link</a></li>
                <li><a href="#">Blabs</a></li>
                <li><a href="#">Following</a></li>
                <li><a href="#">Followers</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a id="button" href="#">
                        <span class="glyphicon glyphicon-user"></span>
                        <c:out value="${pageContext.request.remoteUser}"/>
                    </a>
                    <div class="popover-content popover-content-edit">
                        <ul class="list-group">
                            <li class="list-group-item"><a href="#">Help</a></li>
                            <li class="list-group-item"><a href="#">Settings</a></li>
                            <li>
                                <c:url var="logoutUrl" value="/logout"/>
                                <form action="${logoutUrl}" method="post" id="logoutForm">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="submit" value="Log Out" class="list-group-item"/>
                                </form>
                            </li>
                        </ul>
                    </div>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-user"></span>
                        <c:out value="${pageContext.request.remoteUser}"/>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Help</a></li>
                        <li><a href="#">Settings</a></li>
                        <li class="divider"></li>
                        <li><c:url var="logoutUrl" value="/logout"/>
                            <form action="${logoutUrl}" method="post" id="logoutForm">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <a href="#" role="button"><input class="btn btn-link" type="submit" value="Log Out"/></a>
                            </form>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/masterPage.js"></script>
</body>
</html>
