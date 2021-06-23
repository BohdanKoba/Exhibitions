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
<div class="container">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous">
    </script>
    <div class="table">
        <form action="${contextPath}/app" method="get">
            <input type="hidden" name="command" value="sortExhibitions"/>
            <button type="submit" name="sortBy" value="ByNameInc"><fmt:message key="title"/> &uarr;</button>
            <button type="submit" name="sortBy" value="ByNameDec"><fmt:message key="title"/> &darr;</button>
            <button type="submit" name="sortBy" value="ByPriceInc"><fmt:message key="price"/> &uarr;</button>
            <button type="submit" name="sortBy" value="ByPriceDec"><fmt:message key="price"/> &darr;</button>
        </form>
        <br>
        <form action="${contextPath}/app" method="get">
            <input type="hidden" name="command" value="filterExhibitions"/>
            <input name="dateFrom" id="dateFrom" type="date" required onkeydown="return false"
                   onclick="dateFromLimits()" oninput="enableDateTo()"/>
            <input name="dateTo" id="dateTo" type="date" required onkeydown="return false" onclick="dateToLimits()"
                   disabled/>
            <button type="submit"><fmt:message key="filter"/></button>
            <button><a class="linkButton" href="${contextPath}/view/exhibitions.jsp"><fmt:message key="resetFilter"/></a></button>
        </form>
        <table>
            <colgroup>
                <col span="1" style="width: 14%;">
                <col span="1" style="width: 53%;">
                <col span="1" style="width: 8%;">
                <col span="1" style="width: 12%;">
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
<script>
    function dateFromLimits() {
        let dateFrom = document.getElementById("dateFrom");
        let date = new Date();
        dateFrom.min = date.getFullYear() + '-' + String(date.getMonth() + 1).padStart(2, '0') + '-' + String(date.getDate()).padStart(2, '0');
    }
</script>
<script>
    function dateToLimits() {
        let dateTo = document.getElementById("dateTo");
        let date = new Date(document.getElementById("dateFrom").value);
        let minDate = new Date(date);
        minDate.setDate(date.getDate() + 1);
        dateTo.min = minDate.getFullYear() + '-' + String(minDate.getMonth() + 1).padStart(2, '0') + '-' + String(minDate.getDate()).padStart(2, '0');
    }
</script>
<script>
    function enableDateTo() {
        document.getElementById("dateTo").disabled = false;
    }
</script>
</body>
</html>
