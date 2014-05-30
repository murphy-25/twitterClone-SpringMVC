<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
<head>
    <title>Spring Project Test</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/resources/css/login.css" rel="stylesheet" />
</head>
<body>
    <div class="container">
        <form class="form-signin" role="form" action="/" method="post">
            <h2 class="form-signin-heading">Please sign in</h2>
            <input type="text" class="form-control" id="username" name="username" placeholder="Username" required autofocus>
            <form:errors path="login.username" class="control-label"/>
            <input type="password" class="form-control" id="inputWarning2" name="password" placeholder="Password" required>
            <form:errors path="login.password" class="" />
            <label class="checkbox">
                <input type="checkbox" value="remember-me"> Remember me
            </label>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>.
        </form>
    </div>

    <p pat>${login.username}</p>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
