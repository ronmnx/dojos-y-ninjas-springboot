<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
        </head>
        <body>
            <div id="ninjas">
                <h1>Ninjas</h1>


                <c:forEach begin="1" end="${totalPages}" var="index">
                    <a href="?p=${index}">${index}</a>
                </c:forEach>
                <table class="table">
                    <thead>
                        <th>First Name</th>
                        <th>Last Name</th>
                    </thead>
                    <tbody>

                        <c:forEach var="ninja" items="${ninjas.content}">
                            <tr>
                                <td>
                                    <c:out value="${ninja.firstName}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${ninja.lastName}"></c:out>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </body>
    </html>