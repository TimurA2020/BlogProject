
<%
    User currentUser = (User) request.getAttribute("currentUser");
%>

<nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">South Park Blog</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <%
                    if (currentUser != null) {
                %>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/profile"><%=currentUser.getName()%></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/addblog">Add blog</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Logout</a>
                </li>
                <%
                    }else{
                %>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/profile">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">Register</a>
                </li>
                <%
                    }
                %>

            </ul>
        </div>
    </div>
</nav>