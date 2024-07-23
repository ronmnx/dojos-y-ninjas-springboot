<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Dojos y Ninjas</title>
        </head>
        <body>
            <a href="/dojos/new">New Dojo</a>
            <br>
            <br>
            <a href="/ninjas/new">New Ninja</a>
            <br>
            <br>
            <h1>Information</h1>
            <table>
                <thead>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Ninjas</th>
                    <th>Actions</th>
                </thead>
                <dbody>
                    <c:forEach items="${dojos}" var="dojo">
                        <tr>
                            <td>${dojo.id}</td>
                            <td><a href="dojos/${dojo.id}">${dojo.name}</a></td>
                            <td>${dojo.getNinjas().size()}</td>
                            <td>
                                <form action="dojos/${dojo.id}" method="post">
                                    <input type="hidden" name="_method" value="delete">
                                    <button type="submit">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </dbody>
            </table>
        </body>
    </html>