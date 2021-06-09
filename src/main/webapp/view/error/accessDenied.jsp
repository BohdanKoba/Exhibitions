<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="accessDenied"/></title>
    <jsp:include page="/editStyle/pagestyle.jsp"/>
</head>
<body>
<div class="center">
    <h1>
        <fmt:message key="accessDenied"/>
    </h1>
    <br>
    <a href="${pageContext.request.contextPath}/view/index.jsp"><fmt:message key="backToMainPage"/></a>
</div>
<jsp:include page="/view/fragments/footer.jsp"/>
</body>
</html>
