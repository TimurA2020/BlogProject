<%@ page import="java.util.ArrayList" %>
<%@ page import="blog.model.Post" %>
<%@ page import="blog.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 08.06.2022
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head><title>South Park Blog</title>
<%@include file="head.jsp"%>
    <script src="/js/tinymce/tinymce.min.js" referrerpolicy="origin"></script>
    <script>tinymce.init({selector:'textarea'});</script>
</head>
<body>
<%@include file="navbar.jsp"%>
<%@include file="style.jsp"%>
<%
    if(currentUser!=null){%>
<div class="addblog">
    <form action="/addblog" method="post">
    <img src="<%=currentUser.getProfilePicture()%>" width="50px" style="border-radius: 25%;">
    <div class="row">
        <div class="col-12">
            <label>Title: </label>
        </div>
    </div>
        <div class="row">
            <div class="col-12">
                <input type="text" name="title" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <label>Content: </label>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <textarea name="content" class="form-control"></textarea>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <button type="submit" class="btn btn-success">Add a blogpost</button>
            </div>
        </div>
    </form>
</div>
<%
    }
%>

<%@include file="footer.jsp"%>
</body>
</html>
