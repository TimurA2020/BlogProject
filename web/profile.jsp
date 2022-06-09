<%@ page import="java.util.ArrayList" %>
<%@ page import="blog.model.Post" %>
<%@ page import="blog.model.User" %>
<%@ page import="blog.model.Blog" %>
<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 08.06.2022
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>South Park Blog</title>
<%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<%@include file="style.jsp"%>
<%
    if(currentUser!=null){%>
<div class="profile"><div style="display: flex; margin-bottom: 10px;">
   <div><h1 style="margin-top: 10px;">Welcome <%=currentUser.getName()%></h1></div>
    <div style="margin-left: auto"><img src="<%=currentUser.getProfilePicture()%>" width="100px" style="border-radius: 50%;"></div></div>
    <h6>"<%=currentUser.getQuote()%>"</h6>
</div>
<%
    }
%>
<%
    ArrayList<Blog> blogs = (ArrayList<Blog>) request.getAttribute("blogs");
    if(blogs!=null){
        for(Blog b : blogs){
            %>
<div class="addblog">
    <h1><%=b.getTitle()%></h1>
    <div style="display: flex">
        <div><img src="<%=b.getUser().getProfilePicture()%>" width="50px" style="border-radius: 50%;"></div>
        <div><h6 style="margin-top: 15%; margin-left: 10px;"><%=b.getUser().getName() + " " + b.getUser().getSurname()%></h6></div>
    </div><div class="posts">
    <p><%=b.getContent()%></p></div>
    <a href="/readmore?id=<%=b.getId()%>">Read more</a>
    <%
        String postdate =  b.getPostdate().toString().substring(0, b.getPostdate().toString().length() - 6);
    %>
    <p style="font-size: xx-small">Posted: <%=postdate%></p>
</div>
<%
    }
    }
%>


<%@include file="footer.jsp"%>
</body>
</html>
