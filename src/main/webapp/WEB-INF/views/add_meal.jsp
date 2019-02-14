<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<jsp:include page="components/header.jsp"/>
<body>
<jsp:include page="components/logged_in_top_bar.jsp"/>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <jsp:include page="components/side_panel.jsp"/>

        <div class="m-4 p-3 width-medium">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <div class="row border-bottom border-3 p-1 m-1">
                    <div class="col noPadding">
                        <h3 class="color-header text-uppercase">DODAJ PRZEPIS DO PLANU</h3>
                    </div>
                    <div class="col d-flex justify-content-end mb-2 noPadding">
                        <input type="submit" form="addMeal" value="Zapisz"
                               class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4"/>
                    </div>
                </div>

                <div class="schedules-content">
                    <form:form modelAttribute="meal" id="addMeal" method="post" action="/app/recipe/plan/add">
                        <div class="form-group row">
                            <label for="choosePlan" class="col-sm-2 label-size col-form-label">
                                Wybierz plan
                            </label>
                            <div class="col-sm-3">
                                <form:select path="plan" class="form-control" id="choosePlan">
                                    <form:option value="0" label="--Wybierz plan--"/>
                                    <form:options items="${plans}" itemValue="id" itemLabel="name"/>
                                </form:select>
                                <form:errors path="plan" cssClass="text-error"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 label-size col-form-label">
                                Nazwa posiłku
                            </label>
                            <div class="col-sm-10">
                                <form:input path="mealName" type="text" placeholder="Nazwa posiłku"/><br>
                                <form:errors path="mealName" cssClass="text-error"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 label-size col-form-label">
                                Numer posiłku
                            </label>
                            <div class="col-sm-2">
                                <form:input path="mealOrder" type="number" min="1" step="1"
                                            placeholder="Numer posiłku"/>
                                <form:errors path="mealOrder" cssClass="text-error"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 label-size col-form-label">
                                Przepis
                            </label>
                            <div class="col-sm-4">
                                <form:select path="recipe" class="form-control">
                                    <form:option value="0" label="--Wybierz przepis--"/>
                                    <form:options items="${recipies}" itemLabel="name" itemValue="id"/>
                                </form:select>
                                <form:errors path="recipe" cssClass="text-error"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 label-size col-form-label">
                                Dzień
                            </label>
                            <div class="col-sm-2">
                                <form:select path="dayName" class="form-control">
                                    <form:option value="0" label="--Wybierz dzień--"/>
                                    <form:options items="${allDays}" itemLabel="name" itemValue="id"/>
                                </form:select>
                                <form:errors path="dayName" cssClass="text-error"/>
                            </div>
                        </div>
                    </form:form>
                </div>
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
