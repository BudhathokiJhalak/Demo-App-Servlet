<%@include file="../header.jsp" %>

<div class="container">
    <h1>Add Courses</h1>
    <form method="post">
        <div class="form-group">
            <label>Course Name</label>
            <input type="text" name="name" class="form-control" required="required"/>
        </div>
        <div class="form-group">
            <label>Description</label>
            <textarea name="description" class="form-control" required="required"/></textarea>
        </div>
        <div class="form-group">
            <label>Fee</label>
            <input type="text" name="fees" class="form-control" required="required"/>
        </div>
        <div class="checkbox">
            <label>Status</label>
            <label><input type="checkbox" name="status">Active</label>
        </div>
        <button type="submit" class="btn btn-success">Save</button>
        <a href="" class="btn btn-danger">Back</a>
    </form>
</div>
<%@include file="../footer.jsp" %>