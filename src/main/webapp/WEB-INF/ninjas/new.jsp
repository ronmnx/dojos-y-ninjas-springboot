<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>New ninja</title>
            </head>
            <body>
                <h1>New Ninja</h1>
                <form:form action="new" method="post" modelAttribute="ninja">
                    <p>
                        <form:label path="dojo" for="dojo">Dojo:</form:label>
                        <select name="dojo" id="dojo">
                            <c:forEach items="${dojos}" var="dojo">
                                <option value="${dojo.id}">${dojo.name}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>
                        <form:label path="firstName" for="firstName">First Name: </form:label>
                        <form:input path="firstName" type="text" id="firstName" />
                        <form:errors path="firstName" />
                    </p>
                    <p>
                        <form:label path="lastName" for="lastName">Last Name: </form:label>
                        <form:input path="lastName" type="text" id="firstName" />
                        <form:errors path="lastName" />
                    </p>
                    <p>
                        <form:label path="age" for="age">Age: </form:label>
                        <form:input path="age" type="number" id="age" />
                        <form:errors path="age" />
                    </p>
                    <button type="submit">Guardar</button>
                </form:form>
            </body>
        </html>