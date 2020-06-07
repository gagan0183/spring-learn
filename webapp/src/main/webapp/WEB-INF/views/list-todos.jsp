<html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <title>Todos for ${name}</title>
        <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
              rel="stylesheet">
    </head>
    <body class="container">
        <table class="table table-striped">
            <caption>Your todos here</caption>
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Target date</th>
                    <th>Is it done?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>
                            ${todo.desc}
                        </td>
                        <td>
                            ${todo.targetDate}
                        </td>
                        <td>
                            ${todo.done}
                        </td>
                        <td>
                            <a href="/update-todo?id=${todo.id}" class="btn btn-success" type="button">Update</a>
                        </td>
                        <td>
                            <a href="/delete-todo?id=${todo.id}" class="btn btn-warning" type="button">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a class="button" href="/add-todo">Add to do</a>
        </p>
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </body>
</html>