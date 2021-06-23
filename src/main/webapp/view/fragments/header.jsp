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
        <ul class="nav justify-content-center">
            <li class="nav-item"><a class="nav-link active" aria-current="page"
                                    href="${contextPath}/view/index.jsp"><fmt:message key="mainPage"/></a>
            </li>
            <li class="nav-item"><a class="nav-link active" aria-current="page"
                                    href="${contextPath}/app?command=getExhibitions"><fmt:message
                    key="exhibitions"/></a></li>
            <c:if test="${account.role ne 'admin'}">
                <li class="nav-item"><a class="nav-link active" aria-current="page"
                                        href="${contextPath}/view/client/buyTickets.jsp"><fmt:message
                        key="buyTickets"/></a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page"
                                        href="${contextPath}/view/client/home.jsp"><fmt:message
                        key="homePage"/></a></li>
            </c:if>
            <c:if test="${account.role eq 'admin'}">
                <li class="nav-item"><a class="nav-link active" aria-current="page"
                                        href="${contextPath}/view/admin/statistics.jsp"><fmt:message
                        key="statistics"/></a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page"
                                        href="${contextPath}/view/admin/addExhibition.jsp"><fmt:message
                        key="addExhibition"/></a></li>
            </c:if>
        </ul>
    </div>
    <br>
</div>
</body>
</html>
