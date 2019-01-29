<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: slawek
  Date: 29.01.19
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj przepis</title>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Zaplanuj Jedzonko</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>




<body>


<form:form modelAttribute = "recipe" method = "post" >

    <%--<form:errors path = "*" /> --%>


    <td><b>Nazwa Przepisu</b></td>
    <form:input type="text" path = "name" />
    <form:errors path ="name" />
    <br>

    <td><b>Opis Przepisu</b></td>
    <form:input type="text"  path = "description" />
    <form:errors path ="description" />
    <br>

    <td><b>Skladniki</b></td>
    <form:input type="textarea" path = "ingredients" />
    <form:errors path ="ingredients" />
    <br>

    <td><b>Czas Przygotowania w minutach</b></td>
    <form:input type="number" path = "preparation_time" />
    <form:errors path ="preparation_time" />
    <br>




    <input type = "submit" value="Wyslij" />



</form:form>





</body>

</html>
