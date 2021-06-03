<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="mainPage"/></title>
</head>
<body>
<jsp:include page="common/header.jsp"/>
<figure style="text-align: center">
    <input type="image" alt="test" src="images/friends.jpg" width="40%" height="40%/>
</figure>
<jsp:include page="common/footer.jsp"/>
</body>
</html>
