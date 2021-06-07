<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<html>
<jsp:include page="/editStyle/pagestyle.jsp"/>
<body>
<form action="app" method="post">
    <input type="hidden" name="command" value="setLanguage"/>
    <button type="submit" name="language" value="en">EN</button>
    <button type="submit" name="language" value="uk">UA</button>
</form>
<c:if test="${not signedIn}">
    <div class="header-panel">
        <a href="signIn.jsp"><fmt:message key="signIn"/></a>
    </div>
</c:if>
<c:if test="${signedIn}">
    <div class="header-panel">
        <a href="${contextPath}/app?command=signOut"><fmt:message key="signOut"/></a>
    </div>
</c:if>
<hr>
<div class="navbar">
    <ul>
        <li><a href="${contextPath}/index.jsp"><fmt:message key="mainPage"/></a></li>
        <li><a href="${contextPath}/exhibitions.jsp"><fmt:message key="exhibitions"/></a></li>
        <c:if test="${account.role ne 'admin'}">
            <li><a href="${contextPath}/cart.jsp"><fmt:message key="cart"/></a></li>
        </c:if>
        <c:if test="${account.role eq 'admin'}">
            <li><a href="${contextPath}/jsp/admin/statistics.jsp"><fmt:message key="statistics"/></a></li>
            <li><a href="${contextPath}/jsp/admin/addExhibition.jsp"><fmt:message key="addExhibition"/></a></li>
        </c:if>
        <li><a href="home.jsp"><fmt:message key="homePage"/></a></li>
    </ul>
</div>
</body>
</html>
