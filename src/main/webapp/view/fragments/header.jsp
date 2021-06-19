<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<jsp:include page="/editStyle/pagestyle.jsp"/>
<body>
<div class="container">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous">
    </script>
    <form action="${contextPath}/app" method="post">
        <input type="hidden" name="command" value="setLanguage"/>
        <button type="submit" name="language" value="en">EN</button>
        <button type="submit" name="language" value="uk">UA</button>
    </form>
    <div class="header-panel">
        <c:if test="${empty account}">
            <a class="btn btn-primary" href="${contextPath}/view/signIn.jsp"><fmt:message key="signIn"/></a>
        </c:if>
    </div>
    <div class="header-panel">
        <c:if test="${not empty account}">
            <a class="btn btn-primary" href="${contextPath}/app?command=signOut"><fmt:message key="signOut"/></a>
        </c:if>
    </div>
    <hr>
    <div>
        <ul>
            <li><a href="${contextPath}/view/index.jsp"><fmt:message key="mainPage"/></a></li>
            <li><a href="${contextPath}/app?command=getExhibitions"><fmt:message key="exhibitions"/></a></li>
            <c:if test="${account.role ne 'admin'}">
                <li><a href="${contextPath}/view/buyTickets.jsp"><fmt:message key="buyTickets"/></a></li>
                <li><a href="${contextPath}/view/home.jsp"><fmt:message key="homePage"/></a></li>
            </c:if>
            <c:if test="${account.role eq 'admin'}">
                <li><a href="${contextPath}/view/admin/statistics.jsp"><fmt:message key="statistics"/></a></li>
                <li><a href="${contextPath}/view/admin/addExhibition.jsp"><fmt:message key="addExhibition"/></a></li>
                <li><a href="${contextPath}/view/admin/adminHome.jsp"><fmt:message key="homePage"/></a></li>
            </c:if>
        </ul>
    </div>
</div>
</body>
</html>

<%--    <nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
<%--        <div class="container-fluid">--%>
<%--            <a class="navbar-brand" href="#">Navbar</a>--%>
<%--            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--                <span class="navbar-toggler-icon"></span>--%>
<%--            </button>--%>
<%--            <div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
<%--                <ul class="navbar-nav me-auto mb-2 mb-lg-0">--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link active" aria-current="page" href="#">Home</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="#">Link</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item dropdown">--%>
<%--                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                            Dropdown--%>
<%--                        </a>--%>
<%--                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
<%--                            <li><a class="dropdown-item" href="#">Action</a></li>--%>
<%--                            <li><a class="dropdown-item" href="#">Another action</a></li>--%>
<%--                            <li><hr class="dropdown-divider"></li>--%>
<%--                            <li><a class="dropdown-item" href="#">Something else here</a></li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--                <form class="d-flex">--%>
<%--                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--                    <button class="btn btn-outline-success" type="submit">Search</button>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </nav>--%>


<%--    <div class="navbar">--%>
<%--        <form action="${contextPath}/app" method="post">--%>
<%--            <input type="hidden" name="command" value="goTo"/>--%>
<%--            <button type="submit" name="address" value="view/index.jsp"><fmt:message key="mainPage"/></button>--%>
<%--            <button type="submit" name="address" value="view/exhibitions.jsp"><fmt:message key="exhibitions"/></button>--%>
<%--            <c:if test="${account.role ne 'admin'}">--%>
<%--                <button type="submit" name="address" value="view/buyTickets.jsp"><fmt:message--%>
<%--                        key="buyTickets"/></button>--%>
<%--                <button type="submit" name="address" value="view/home.jsp"><fmt:message key="homePage"/></button>--%>
<%--            </c:if>--%>
<%--            <c:if test="${account.role eq 'admin'}">--%>
<%--                <button type="submit" name="address" value="view/admin/statistics.jsp"><fmt:message key="statistics"/></button>--%>
<%--                <button type="submit" name="address" value="view/admin/addExhibition.jsp"><fmt:message key="addExhibition"/></button>--%>
<%--                <button type="submit" name="address" value="view/admin/adminHome.jsp"><fmt:message key="homePage"/></button>--%>
<%--            </c:if>--%>
<%--        </form>--%>
<%--    </div>--%>
