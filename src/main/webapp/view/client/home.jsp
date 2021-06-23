<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="homePage"/></title>
</head>
<body>
<jsp:include page="../fragments/header.jsp"/>
<div class="center">
    <br>
    <h3 class="center">My info</h3>
    <div>
        <strong><fmt:message key="firstName"/></strong>
    </div>
    <input name="login" type="text" value="${account.firstName}" readonly/>
    <br>
    <div>
        <strong><fmt:message key="lastName"/></strong>
    </div>
    <input name="login" type="text" value="${account.lastName}" readonly/>
    <br>
    <div>
        <strong><fmt:message key="email"/></strong>
    </div>
    <input name="login" type="text" value="${account.email}" readonly/>
    <br>
</div>
<div>
    <br>
    <h3 class="center"><fmt:message key="myPurchases"/></h3>
    <div>
        <table class="center" id="tableCenter">
            <colgroup>
                <col span="1" style="width: 200px;">
                <col span="1" style="width: 150px;">
                <col span="1" style="width: 120px;">
                <col span="1" style="width: 120px;">
                <col span="1" style="width: 150px;">
                <col span="1" style="width: 120px;">
            </colgroup>
            <tr>
                <th><h3><fmt:message key="title"/></h3></th>
                <th><h3><fmt:message key="date"/></h3></th>
                <th><h3><fmt:message key="time"/></h3></th>
                <th><h3><fmt:message key="price"/>, <fmt:message key="uah"/></h3></th>
                <th><h3><fmt:message key="quantity"/></h3></th>
                <th><h3><fmt:message key="total"/></h3></th>
            </tr>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.title}</td>
                    <td>${order.startDate} - ${order.endDate}</td>
                    <td>${order.openingTime} - ${order.closingTime}</td>
                    <td>${order.price}</td>
                    <td><${order.quantity}</td>
                    <td>${order.bill}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
