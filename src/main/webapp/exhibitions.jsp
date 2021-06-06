<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="exhibitions"/></title>
    <jsp:include page="/editStyle/tablestyle.jsp"/>
</head>
<body>
<jsp:include page="jsp/fragments/header.jsp"/>
<c:if test="${empty exhibitions}">
    <c:import url="app?command=getExhibitions"/>
</c:if>
<div>
    <div>
        <h2 class="center"><fmt:message key="exhibitions"/></h2>
        <form action="app" method="post">
            <input type="hidden" name="command" value="sortExhibitions"/>
            <button type="submit" name="sortBy" value="ByNameInc"><fmt:message key="title"/> &uarr;</button>
            <button type="submit" name="sortBy" value="ByNameDec"><fmt:message key="title"/> &darr;</button>
            <button type="submit" name="sortBy" value="ByPriceInc"><fmt:message key="price"/> &uarr;</button>
            <button type="submit" name="sortBy" value="ByPriceDec"><fmt:message key="price"/> &darr;</button>
        </form>
        <table>
            <colgroup>
                <col span="1" style="width: 14%;">
                <col span="1" style="width: 63%;">
                <col span="1" style="width: 5%;">
                <col span="1" style="width: 10%;">
                <col span="1" style="width: 8%;">
            </colgroup>
            <tr>
                <th><h3><fmt:message key="title"/></h3></th>
                <th><h3><fmt:message key="description"/></h3></th>
                <th><h3><fmt:message key="price"/></h3></th>
                <th><h3><fmt:message key="date"/></h3></th>
                <th><h3><fmt:message key="time"/></h3></th>
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
                    <c:choose>
                        <c:when test="${account.role eq 'admin'}">
                            <td style="border: none">
                                <form action="app" method="post">
                                    <label><fmt:message key="${exhibition.status}"/></label>
                                    <br><br>
                                    <input type="hidden" name="command" value="changeStatus"/>
                                    <button type="submit" name="exhibitionId" value="${exhibition.id}"><fmt:message key="change"/></button>
                                </form>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td style="border: none">
                                <form action="app" method="post">
                                    <input type="hidden" name="command" value="addToCart"/>
                                    <button type="submit" name="exhibitionId" value="${exhibition.id}"><fmt:message key="addToCart"/></button>
                                </form>
                            </td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="jsp/fragments/footer.jsp"/>
</body>
</html>
