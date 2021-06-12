<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<jsp:include page="/editStyle/pagestyle.jsp"/>
<body>
<form action="${contextPath}/app" method="post">
    <input type="hidden" name="command" value="setLanguage"/>
    <button type="submit" name="language" value="en">EN</button>
    <button type="submit" name="language" value="uk">UA</button>
</form>
<c:if test="${not signedIn}">
    <div class="header-panel">
        <button style="width: 100px"><a class="linkButton" href="${contextPath}/view/signIn.jsp"><fmt:message
                key="signIn"/></a></button>
    </div>
</c:if>
<c:if test="${signedIn}">
    <form class="header-panel" action="${contextPath}/app" method="post">
        <input type="hidden" name="command" value="signOut"/>
        <button type="submit"><fmt:message key="signOut"/></button>
    </form>
</c:if>
<hr>
<div class="navbar">
    <form action="${contextPath}/app" method="post">
        <input type="hidden" name="command" value="goTo"/>
        <button type="submit" name="address" value="view/index.jsp"><fmt:message key="mainPage"/></button>
        <button type="submit" name="address" value="view/exhibitions.jsp"><fmt:message key="exhibitions"/></button>
        <c:if test="${account.role ne 'admin'}">
            <button type="submit" name="address" value="view/buyTickets.jsp"><fmt:message key="buyTickets"/></button>
            <button type="submit" name="address" value="view/home.jsp"><fmt:message key="homePage"/></button>
        </c:if>
        <c:if test="${account.role eq 'admin'}">
            <button type="submit" name="address" value="view/admin/statistics.jsp"><fmt:message key="statistics"/></button>
            <button type="submit" name="address" value="view/admin/addExhibition.jsp"><fmt:message key="addExhibition"/></button>
            <button type="submit" name="address" value="view/admin/adminHome.jsp"><fmt:message key="homePage"/></button>
        </c:if>
    </form>
</div>
</body>
</html>
