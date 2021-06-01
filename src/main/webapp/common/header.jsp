<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<html>
<body>
<form action="app" method="post">
    <input type="hidden" name="command" value="setLanguage"/>
    <button type="submit" name="language" value="en">EN</button>
    <button type="submit" name="language" value="uk">UA</button>
</form>
<h1 style="text-align: center"><fmt:message key="exhibitions"/></h1>
<%--<c:if test="${userLoggedIn}">--%>
<%--    <div style="display: flex; justify-content: flex-end">--%>
<%--        <a href="/Servlet?command=logout"><fmt:message key="logOut"/></a>--%>
<%--    </div>--%>
<%--</c:if>--%>
<hr>
</body>
</html>
