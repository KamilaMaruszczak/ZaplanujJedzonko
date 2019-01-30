<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="components/header.jsp"/>
<body>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="/" class="navbar-brand main-logo">
            Zaplanuj <span>Jedzonko</span>
        </a>
        <ul class="nav nounderline text-uppercase">
            <li class="nav-item ml-4">

                <c:choose>
                    <c:when test="${sessionScope.admin.email!=null}">
                        <a class="nav-link color-header" href="/logout">wylogowanie</a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link color-header" href="/login">logowanie</a>
                    </c:otherwise>
                </c:choose>

            </li>

            <c:if test="${sessionScope.admin.email==null}">
                <li class="nav-item ml-4">
                    <a class="nav-link color-header" href="/register">rejestracja</a>
                </li>
            </c:if>

            <li class="nav-item ml-4">
                <a class="nav-link" href="/#about">o aplikacji</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="recipes.html">Przepisy</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="/#contact">Kontakt</a>
            </li>
        </ul>
    </nav>
</header>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <form:form modelAttribute="admin" method="post" class="padding-small text-center">
                    <h1 class="text-color-darker">Rejestracja</h1>

                    <span class="text-error">${errorMessage}</span>
                    <div class="form-group">
                        <form:input path="firstname" class="form-control" placeholder="podaj imię"/>
                        <small class="form-text text-error"><form:errors path="firstname"/></small>
                    </div>
                    <div class="form-group">
                        <form:input path="lastname" class="form-control" placeholder="podaj nazwisko"/>
                        <small class="form-text text-error"><form:errors path="lastname"/></small>
                    </div>
                    <div class="form-group">
                        <form:input path="email" class="form-control" placeholder="podaj email"/>
                        <small class="form-text text-error"><form:errors path="email"/></small>
                    </div>
                    <div class="form-group">
                        <form:password path="password" class="form-control" placeholder="podaj hasło"/>
                        <small class="form-text text-error"><form:errors path="password"/></small>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password2" placeholder="powtórz hasło">
                        <small class="form-text text-error">${password2Message}</small>
                    </div>
                    <button class="btn btn-color rounded-0" type="submit">Zarejestruj</button>
                </form:form>
            </div>
        </div>
    </div>
</section>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>