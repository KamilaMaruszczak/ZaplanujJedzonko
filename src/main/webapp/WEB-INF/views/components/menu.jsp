<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a class="nav-link disabled" href="/app/recipe/list/">Przepisy</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="/#contact">Kontakt</a>
            </li>
        </ul>
    </nav>
</header>