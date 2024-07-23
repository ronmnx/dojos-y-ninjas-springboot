<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>New Dojo</title>
            </head>
            <body>
                <h1>New Dojo</h1>
                <form:form action="" method="post" modelAttribute="dojo">
                    <p>
                        <form:label path="name" for="name">Name</form:label>
                        <form:input path="name" type="text" id="name" />
                        <form:errors path="name" />
                    </p>
                    <button type="submit">Guardar</button>
                </form:form>
            </body>
        </html>