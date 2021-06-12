<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="mainPage"/></title>
    <jsp:include page="/editStyle/pagestyle.jsp"/>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<figure class="center">
    <h2 class="center">Welcome page</h2>
    <input type="image" alt="test" src="${contextPath}/img/friends.jpg" width="40%" height="40%/>
</figure>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
