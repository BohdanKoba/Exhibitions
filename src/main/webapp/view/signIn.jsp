<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="signInTitle"/></title>
    <jsp:include page="/editStyle/pagestyle.jsp"/>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<div>
    <form action="${contextPath}/app" method="post" class="form-style" id="signIn">
        <h2 style="margin-top: -5px"><fmt:message key="signInTitle"/></h2>
        <div>
            <input type="hidden" name="command" value="signIn"/>
            <label><input name="login" type="text" placeholder="<fmt:message key="login"/>"/></label>
        </div>
        <br>
        <div>
            <label><input name="password" type="password" placeholder="<fmt:message key="password"/>"/></label>
        </div>
        <br>
        <input style="width: 60px" type="submit" value="<fmt:message key="signIn"/>"/>
        <br>
        <p><fmt:message key="haveAccountQestion"/></p>
        <a href="${contextPath}/view/registration.jsp"><strong><fmt:message key="signUp"/></strong></a>
    </form>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
