<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Add todo</title>
        <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
              rel="stylesheet">
    </head>
    <body class="container">
        <form:form method="post" modelAttribute="todo">
            <fieldset class="form-group">
                <form:hidden path="id"></form:hidden>
                <form:label path="desc">Description</form:label>
                <form:input path="desc" name="desc" type="text" class="form-control" required="required"></form:input>
                <form:errors path="desc" cssClass="text-warning"></form:errors>
            </fieldset>
            <button type="submit" class="btn btn-success">Add To Do</button>
        </form:form>
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </body>
</html>