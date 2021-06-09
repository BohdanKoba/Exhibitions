<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="register"/></title>
    <jsp:include page="/editStyle/pagestyle.jsp"/>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<div>
    <form action="${contextPath}/app" method="post" class="form-style" id="register">
        <input type="hidden" name="command" value="register"/>
        <div>
            <strong><fmt:message key="login"/></strong>
        </div>
        <input name="login" type="text" pattern="^[^\s$/()]+$" minlength="5" maxlength="25" required/>
        <br><br>
        <div>
            <strong><fmt:message key="password"/></strong>
        </div>
        <input name="password" type="password" pattern="^[^\s]+$" minlength="6" maxlength="20" required/>
        <br><br>
        <div>
            <strong><fmt:message key="firstName"/></strong>
        </div>
        <input name="firstName" type="text" pattern="^\p{Lu}\p{Ll}+$" minlength="2" maxlength="50" required/>
        <br><br>
        <div>
            <strong><fmt:message key="lastName"/></strong>
        </div>
        <input name="lastName" type="text" pattern="^\p{Lu}\p{Ll}+$" minlength="2" maxlength="50" required/>
        <br><br>
        <div>
            <strong><fmt:message key="email"/></strong>
        </div>
        <input name="email" type="email" required/>
        <br><br>
        <input style="width: 140px" type="submit" value="<fmt:message key="register"/>"/>
    </form>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
