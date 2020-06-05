<html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <title>Todos for ${name}</title>
    </head>
    <body>
        <h1>Your todos</h1>
        <table>
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
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="/add-todo">Add to do</a>
        </p>
    </body>
</html>