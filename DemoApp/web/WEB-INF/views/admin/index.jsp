<%@include file="../header.jsp" %>

<h1>Welcome to admin panel</h1>
<div class="pull-right">
    <a href="addcourse" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-plus">ADD</span></a>
</div>
<form>
    <div>
        <table class="table table-hover">
            <tr>
                <th>ID</th>
                <th>Course Name</th>
                <th>Description</th>
                <th>Fees</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:forEach var="course" items="${requestScope.courses}">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.name}</td>
                    <td>${course.description}</td>
                    <td>${course.fees}</td>
                    <td>${course.status}</td>
                    <td>
                        <a href="editcourse.jsp?id=${course.id}" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil"></span></a>
                        <a href="deletecourse.jsp?id=${course.id}" class="btn btn-danger btn-xs" onclick="return confirm('Are you sure to delete?')"><span class="glyphicon glyphicon-trash"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
<div class="pull-right">
    <form action="logoutController">
        <button type="submit">Logout</button>
    </form>
</div>
<%@include file="../footer.jsp" %>