<%@include file="header.jsp" %>

<div class="container">
    <div>
        <h1> Please Login..</h1>
    </div>
    <c:if test="${param.error!=null}">
        Invalid UserName and Password
    </c:if>

    <form method="post">
        <div>
            <label>UserName</label>
            <input type="text" name="username"/>
        </div>
        <div>
            <label>Password</label>
            <input type="password" name="password"/>
        </div>
        <button type="submit">Login</button>
    </form>
</div>
<%@include file="footer.jsp" %>
