<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="revenue" uri="http://koba.com/exhibitions" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="statistics"/></title>
    <jsp:include page="/editStyle/pagestyle.jsp"/>
</head>
<body>
<jsp:include page="../fragments/header.jsp"/>
<div>
    <h2 class="center"><fmt:message key="visitStatistics"/></h2>
    <div>
        <table id="tableCenter">
            <colgroup>
                <col span="1" style="width: 320px;">
                <col span="1" style="width: 180px;">
                <col span="1" style="width: 120px;">
                <col span="1" style="width: 110px;">
                <col span="1" style="width: 150px;">
            </colgroup>
            <tr>
                <th><h3><fmt:message key="title"/></h3></th>
                <th><h3><fmt:message key="date"/></h3></th>
                <th><h3><fmt:message key="price"/></h3></th>
                <th><h3><fmt:message key="ticketsSold"/></h3></th>
                <th><h3><fmt:message key="revenue"/></h3></th>
            </tr>
            <c:forEach var="exhibition" items="${exhibitions}">
                <tr>
                    <td>${exhibition.title}</td>
                    <td>${exhibition.startDate} - ${exhibition.endDate}</td>
                    <td>${exhibition.price}</td>
                    <td>${exhibition.ticketsSold}</td>
                    <td><revenue:getValue exhibition="${exhibition}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
