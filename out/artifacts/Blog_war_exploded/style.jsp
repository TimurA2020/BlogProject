<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 08.06.2022
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    body {
        font: 13px/20px "Lucida Grande", Tahoma, Verdana, sans-serif;
        color: #404040;
        background: #0ca3d2;
    }

    nav{
        background-color: #0ca3d2;
        border-bottom: 1px;
    }

    .posts img{
        width: 500px;
    }
    .profile {
        position: relative;
        margin: 30px auto;
        padding: 20px 20px 20px;
        width: 600px;
        background: white;
        border-radius: 3px;
        -webkit-box-shadow: 0 0 200px rgba(255, 255, 255, 0.5), 0 1px 2px rgba(0, 0, 0, 0.3);
        box-shadow: 0 0 200px rgba(255, 255, 255, 0.5), 0 1px 2px rgba(0, 0, 0, 0.3);
    }

    .addblog {
        position: relative;
        margin: 30px auto;
        padding: 20px 20px 20px;
        width: 700px;
        background: white;
        border-radius: 3px;
        -webkit-box-shadow: 0 0 200px rgba(255, 255, 255, 0.5), 0 1px 2px rgba(0, 0, 0, 0.3);
        box-shadow: 0 0 200px rgba(255, 255, 255, 0.5), 0 1px 2px rgba(0, 0, 0, 0.3);
    }

    .comment {
        position: relative;
        margin: 10px auto;
        padding: 20px 20px 20px;
        width: 550px;
        background: white;
        border-radius: 20px;
        -webkit-box-shadow: 0 0 200px rgba(255, 255, 255, 0.5), 0 1px 2px rgba(0, 0, 0, 0.3);
        box-shadow: 0 0 200px rgba(255, 255, 255, 0.5), 0 1px 2px rgba(0, 0, 0, 0.3);
    }

    <%@include file="loginstyle.jsp"%>
</style>
