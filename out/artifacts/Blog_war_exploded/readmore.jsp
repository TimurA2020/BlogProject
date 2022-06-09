<%@ page import="java.util.ArrayList" %>
<%@ page import="blog.model.Post" %>
<%@ page import="blog.model.User" %>
<%@ page import="blog.model.Blog" %>
<%@ page import="blog.model.Comment" %><%--
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
    Blog b = (Blog) request.getAttribute("blog");
    if(b!=null){
            %>
<div class="addblog">
    <h1><%=b.getTitle()%></h1>
    <div style="display: flex">
        <div><img src="<%=b.getUser().getProfilePicture()%>" width="50px" style="border-radius: 50%;"></div>
        <div><h6 style="margin-top: 15%; margin-left: 10px;"><%=b.getUser().getName() + " " + b.getUser().getSurname()%></h6></div>
    </div>
    <div class="posts">
    <p><%=b.getContent()%></p>
        <%
            if(currentUser!=null){
        %>
        <form action="/addcomment" method="post">
            <input type="hidden" name="blog_id" value="<%=b.getId()%>">
            <div class="row">
                <div class="col-12">
                    <textarea class="form-control" name="comment" style="margin-bottom: 10px"></textarea>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <p class="submit"><input type="submit" name="commit" value="Comment"></p>
                </div>
            </div>
        </form>
        <%
            }
            }
        %>
    </div>
</div>


    <div class="comment">
        <%
            ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");
            if (comments!=null){
                for (Comment comment : comments){
        %>
        <h3><%=comment.getUser().getName() + " " + comment.getUser().getSurname()%></h3>
        <div style="display: flex; ">
            <div><img src="<%=comment.getUser().getProfilePicture()%>" width="50px" style="border-radius: 50%;"></div>
            <div><h6 style="margin-left: 10px; line-height: 50px"><%=comment.getComment()%></h6></div>
        </div>
    <%
        //removing extra mili-micro-nano seconds from the postdate
        String commentDate =  comment.getPostdate().toString().substring(0, comment.getPostdate().toString().length() - 6);
    %>
    <p style="font-size: xx-small">Posted: <%=commentDate%></p>
        <hr>
        <%
                }
            }
        %>

</div>


<%@include file="footer.jsp"%>
</body>
</html>
