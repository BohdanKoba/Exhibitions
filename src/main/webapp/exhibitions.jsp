<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="exhibitions"/></title>
    <jsp:include page="/common/tablestyle.jsp"/>
</head>
<body>
<jsp:include page="common/header.jsp"/>
<div style="display: flex; justify-content: space-between; margin: 0 20px;">
    <div>
        <h2 style="text-align:center"><fmt:message key="availableExhibitions"/></h2>
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
            </tr>
            <c:forEach var="exhibition" items="${exhibitions}">
                <tr>
                    <td>${exhibition.title}</td>
                    <td>${exhibition.description}</td>
                    <td>${exhibition.price}</td>
                    <td>${exhibition.startDate} - ${exhibition.endDate}</td>
                    <td>${exhibition.openingTime} - ${exhibition.closingTime}</td>
                    <c:if test="${account.role ne 'admin'}">
                        <td style="border: none">
                            <form action="app" method="post">
                                <input type="hidden" name="command" value="addToCart"/>
                                <button type="submit"><fmt:message key="addToCart"/></button>
                            </form>
                        </td>
                    </c:if>
                    <c:if test="${account.role eq 'admin'}">
                        <td style="border: none">
                            <form action="app" method="post">
                                <input type="hidden" name="command" value="goTo"/>
                                <button type="submit" name="exhibition" value="${exhibition.id}"><fmt:message key="edit"/></button>
                            </form>
                        </td>
<%--                        <td style="border: none">--%>
<%--                            <form qaction="editExhibition.jsp">--%>
<%--                                <input type="submit" onclick="<a href="" " value="<fmt:message key="edit"/>"/>--%>
<%--                            </form>--%>

<%--&lt;%&ndash;                            <form action="app" method="post">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <input type="hidden" name="command" value="addToCart"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <button type="submit" value="${exhibition}"><fmt:message key="edit"/></button>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </form>&ndash;%&gt;--%>
<%--                        </td>--%>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>
