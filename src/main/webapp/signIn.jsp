<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="signInTitle"/></title>
</head>
<body>
<jsp:include page="common/header.jsp"/>
<div style="display: flex; justify-content: space-between; margin: 0 20px;">
    <div>
        <h2><fmt:message key="signInTitle"/></h2>
        <form action="app" method="post">
            <input type="hidden" name="command" value="signIn"/>
            <label><input name="login" type="text" placeholder="<fmt:message key="login"/>"/></label>
            <br>
            <label><input name="password" type="password" placeholder="<fmt:message key="password"/>"/></label>
            <br>
            <button type="submit"><fmt:message key="signIn"/> </button>
        </form>
<%--        <c:if test="${not empty requestScope.errorMessage}">--%>
<%--            <p style="color: red">Wrong Login or Password</p>--%>
<%--        </c:if>--%>
    </div>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>
