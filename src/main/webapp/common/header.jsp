<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<html>
<jsp:include page="/common/pagestyle.jsp"/>
<body>
<form action="app" method="post">
    <input type="hidden" name="command" value="setLanguage"/>
    <button type="submit" name="language" value="en">EN</button>
    <button type="submit" name="language" value="uk">UA</button>
</form>
<c:if test="${not signedIn}">
    <div style="display: flex; justify-content: flex-end">
        <a href="registration.jsp"><fmt:message key="signUp"/></a>
    </div>
</c:if>
<c:if test="${not signedIn}">
    <div style="display: flex; justify-content: flex-end">
        <a href="signIn.jsp"><fmt:message key="signIn"/></a>
    </div>
</c:if>
<c:if test="${signedIn}">
    <div style="display: flex; justify-content: flex-end">
        <a href="app?command=signOut"><fmt:message key="signOut"/></a>
    </div>
</c:if>
<hr>
<ul id="navbar">
    <li><a href="index.jsp"><fmt:message key="mainPage"/></a></li>
    <li><a href="app?command=exhibitions"><fmt:message key="exhibitions"/></a></li>
    <c:if test="${account.role ne 'admin'}">
        <li><a href="cart.jsp"><fmt:message key="cart"/></a></li>
    </c:if>
    <c:if test="${account.role eq 'admin'}">
        <li><a href="statistics.jsp"><fmt:message key="statistics"/></a></li>
        <li><a href="addExhibition.jsp"><fmt:message key="addExhibition"/></a></li>
    </c:if>
    <li><a href="home.jsp"><fmt:message key="homePage"/></a></li>
</ul>
</body>
</html>
