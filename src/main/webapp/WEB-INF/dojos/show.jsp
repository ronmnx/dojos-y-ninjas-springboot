<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>${dojo.name}</title>
        </head>
        <body>
            <h1>Dojo: ${dojo.name}</h1>
            <table>
                <thead>
                    <th>uid</th>
                    <th>Fist Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Actions</th>
                </thead>
                <tbody>
                    <c:forEach items="${ninjas}" var="ninja">
                        <tr>
                            <td>${ninja.id}</td>
                            <td>${ninja.firstName}</td>
                            <td>${ninja.lastName}</td>
                            <td>${ninja.age}</td>
                            <td>
                                <form action="/ninjas/${ninja.id}" method="post">
                                    <input type="hidden" name="_method" value="delete">
                                    <button type="submit">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </body>
    </html>