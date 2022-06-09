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
    <h1>Register</h1>
    <form method="post" action="/register">
        <p><input type="text" name="email" placeholder="Email" required></p>
        <%
            String usererror = request.getParameter("usererror");
            if (usererror!=null){
        %>
        <div class="alert alert-danger" role="alert">
            This user already exists!
        </div>
        <%
            }
        %>
        <p><input type="password" name="password" placeholder="Password" required></p>
        <p><input type="password" name="password2" placeholder="Repeat you password" required></p>
        <%
            String passworderror = request.getParameter("passworderror");
            if (passworderror!=null){
        %>
        <div class="alert alert-danger" role="alert">
            Passwords don't match!
        </div>
        <%
            }
        %>
        <p><input type="text" name="name" placeholder="Name" required></p>
        <p><input type="text" name="surname" placeholder="Surname" required></p>
        <p><input type="text" name="quote" placeholder="Enter your motto" required></p>
        <p><input type="text" name="picture" placeholder="Enter your picture URL" required></p>
        <%
            String success = request.getParameter("success");
            if (success!=null){
        %>
        <div class="alert alert-success" role="alert">
            Your registration is complete!
        </div>
        <%
            }
        %>
        <p class="remember_me">
            <label>
                <input type="checkbox" name="remember_me" id="remember_me">
                Remember me
            </label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="Register"></p>
    </form>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
