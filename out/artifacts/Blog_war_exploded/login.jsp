<%@ page import="java.util.ArrayList" %>
<%@ page import="blog.model.Post" %>
<%@ page import="blog.model.User" %>


<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 08.06.2022
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>login</title>
<%@include file="head.jsp"%>
</head>
<body>
<%@include file="style.jsp"%>
<%@include file="navbar.jsp"%>
<div class="login">
    <h1>Login to Web App</h1>
    <form method="post" action="/login">
        <%
            String userError = request.getParameter("usererror");
            if (userError!=null){
        %>
        <div class="alert alert-danger" role="alert">
            Wrong username or password!
        </div>
        <%
            }
        %>
        <p><input type="text" name="login" placeholder="Username or Email"></p>
        <p><input type="password" name="password" placeholder="Password"></p>
        <p class="remember_me">
            <label>
                <input type="checkbox" name="remember_me" id="remember_me">
                Remember me on this computer
            </label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="Login"></p>
    </form>
</div>

<div class="login-help">
    <p>Forgot your password? <a href="#">Click here to reset it</a>.</p>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
