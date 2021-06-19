<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="exhibitions"/></title>
    <jsp:include page="/editStyle/pagestyle.jsp"/>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<div>
    <div class="table">
        <form action="${contextPath}/app" method="get">
            <input type="hidden" name="command" value="sortExhibitions"/>
            <button type="submit" name="sortBy" value="ByNameInc"><fmt:message key="title"/> &uarr;</button>
            <button type="submit" name="sortBy" value="ByNameDec"><fmt:message key="title"/> &darr;</button>
            <button type="submit" name="sortBy" value="ByPriceInc"><fmt:message key="price"/> &uarr;</button>
            <button type="submit" name="sortBy" value="ByPriceDec"><fmt:message key="price"/> &darr;</button>
        </form>
        <form action="${contextPath}/app" method="get">
            <input type="hidden" name="command" value="filterExhibitions"/>
            <input name="dateFrom" type="date"/>
            <input name="dateTo" type="date"/>
            <button type="submit"><fmt:message key="filter"/></button>
<%--            <button type="submit" name="filter" <a href="${contextPath}/view/exhibitions.jsp"/><fmt:message key="resetFilter"/></button>--%>
        </form>
        <table>
            <colgroup>
                <col span="1" style="width: 14%;">
                <col span="1" style="width: 55%;">
                <col span="1" style="width: 8%;">
                <col span="1" style="width: 10%;">
                <col span="1" style="width: 8%;">
                <col span="1" style="width: 5%;">
            </colgroup>
            <tr>
                <th><h3><fmt:message key="title"/></h3></th>
                <th><h3><fmt:message key="description"/></h3></th>
                <th><h3><fmt:message key="price"/>, <fmt:message key="uah"/></h3></th>
                <th><h3><fmt:message key="date"/></h3></th>
                <th><h3><fmt:message key="time"/></h3></th>
                <th><h3><fmt:message key="halls"/></h3></th>
                <c:if test="${account.role eq 'admin'}">
                    <th><h3><fmt:message key="status"/></h3></th>
                </c:if>
            </tr>
            <c:forEach var="exhibition" items="${exhibitions}">
                <tr>
                    <td>${exhibition.title}</td>
                    <td>${exhibition.description}</td>
                    <td>${exhibition.price}</td>
                    <td>${exhibition.startDate} - ${exhibition.endDate}</td>
                    <td>${exhibition.openingTime} - ${exhibition.closingTime}</td>
                    <td>
                        <c:forEach var="hall" items="${exhibition.exhibitionHalls}">
                            ${hall.hallName}
                        </c:forEach>
                    </td>
                    <c:if test="${account.role eq 'admin'}">
                        <td style="border: none">
                            <form action="${contextPath}/app" method="post">
                                <label><fmt:message key="${exhibition.status}"/></label>
                                <br><br>
                                <input type="hidden" name="command" value="changeStatus"/>
                                <button type="submit" name="exhibitionId" value="${exhibition.id}"><fmt:message
                                        key="change"/></button>
                            </form>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
