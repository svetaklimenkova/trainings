<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><spring:message code="main.brand"/></title>
    <link rel="shortcut icon" href="/static/icon.png" type="image/png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">

    <!-- Project CSS -->
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/navbar.css">
    <link rel="stylesheet" type="text/css" href="/css/form.css">
    <link rel="stylesheet" type="text/css" href="/css/mylist.css">

    <!-- Font -->
    <link href="/fonts/caveat.css" rel="stylesheet">
</head>
<body>
<!-- Navigation Bar -->
<header>
    <nav class="navbar mynav">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    <spring:message code="main.brand"/>
                </a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <spring:message code="main.language"/>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="?lang=ru">RU</a></li>
                        <li><a href="?lang=en">EN</a></li>
                    </ul>
                </li>
                <li><a id="username"></a></li>
                <li><a href="/logout"><spring:message code="main.exit"/></a></li>
            </ul>
        </div>
    </nav>
</header>

<main>
    <div class="container">
        <div class="row">
            <div class="navi col-xs-12 col-sm-6 col-md-4 col-lg-3">
                <ul>
                    <li class="active">
                        <a href="/applications">
                            <i class="fa fa-home" aria-hidden="true"></i>
                            <span class="hidden-xs hidden-sm"><spring:message code="applications.title"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="/users">
                            <i class="fa fa-calendar" aria-hidden="true"></i>
                            <span class="hidden-xs hidden-sm"><spring:message code="user_management.title"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="/categories">
                            <i class="fa fa-cog" aria-hidden="true"></i>
                            <span class="hidden-xs hidden-sm"><spring:message code="training_categories.title"/></span>
                        </a>
                    </li>
                </ul>
            </div>

            <div id='content' class="content col-xs-12 col-sm-6 col-md-8 col-lg-9">
                <div class="row">
                    <div class="col-xs-12 title"><b><spring:message code="applications.one"/> ${application.id}</b></div>

                    <input id="id" type="hidden" value="${application.id}">

                    <div class="col-xs-4"><b><spring:message code="applications.type"/></b></div>
                    <div id="type" class="col-xs-8"></div>

                    <div class="col-xs-4"><b><spring:message code="form.username"/></b></div>
                    <div id="receiver" class="col-xs-8"></div>

                    <div class="col-xs-4"><b><spring:message code="form.mail"/></b></div>
                    <div id="mail" class="col-xs-8"></div>

                    <div class="col-xs-4"><b><spring:message code="applications.createdBy"/></b></div>
                    <div id="createdBy" class="col-xs-8"></div>

                    <div class="col-xs-4"><b><spring:message code="applications.updatedBy"/></b></div>
                    <div id="updatedBy" class="col-xs-8"></div>

                    <div class="col-xs-4"><b><spring:message code="applications.status"/></b></div>
                    <div id="status" class="col-xs-8"></div>

                    <div class="col-xs-4"><b><spring:message code="form.message"/></b></div>
                    <div id="description" class="col-xs-8"></div>

                    <div class="col-xs-6">
                        <div class="button">
                            <button id="accept" type="button"><spring:message code="applications.accept"/></button>
                        </div>
                    </div>
                    <div class="col-xs-6 ">
                        <div class="button">
                            <button id="reject" type="button"><spring:message code="applications.reject"/></button>
                        </div>
                    </div>

                    <div class="col-xs-offset-3 col-xs-6 ">
                        <div class="button">
                            <button id="delete" type="button"><spring:message code="applications.delete"/></button>
                        </div>
                    </div>

                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </div>
            </div>

            <div class="clearfix"></div>
            <div class="myclearfix col-sm-12"></div>

        </div>
    </div>
</main>

<footer>
    <div class="container">
        <div class="row">
            <div class="spin col-xs-12"></div>
            <div class="clearfix hidden-xs"></div>

            <div class="col-xs-12 col-sm-3 col-md-2">
                <spring:message code="main.support"/><br>
                svetaklimenkova@mail.ru<br>
                svetkaklimenkova98@gmail.com</div>
            <div class="col-xs-12 col-sm-4 col-md-3"></div>
            <div class="col-xs-12 col-sm-5 col-md-offset-3 col-md-4" style="text-align: end">
                © 2018 SLIVKI<br>
                <spring:message code="main.brand_text"/>
            </div>
        </div>
    </div>
</footer>

<script src="/js/fr/jquery-3.3.1.min.js"></script>
<script src="/js/fr/bootstrap.min.js"></script>
<script src="/js/fr/list.min.js"></script>

<script src="/js/com/username.js"></script>

<script src="/js/admin/application.js"></script>
</body>
</html>