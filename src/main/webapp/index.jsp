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
<jsp:include page="jsp/fragments/header.jsp"/>
<figure class="center">
    <input type="image" alt="test" src="img/friends.jpg" width="40%" height="40%/>
</figure>
<jsp:include page="jsp/fragments/footer.jsp"/>
</body>
</html>
