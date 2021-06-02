<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="exhibitions"/></title>
</head>
<body>
<jsp:include page="common/header.jsp"/>
<br/>
<div style="display: flex; justify-content: space-between; margin: 0 20px;">
    <div>
        <h2><fmt:message key="availableExhibitions"/></h2>
        <table  border="2" style="width: 100%">
            <colgroup>
                <col span="1" style="width: 14%;">
                <col span="1" style="width: 65%;">
                <col span="1" style="width: 5%;">
                <col span="1" style="width: 8%;">
                <col span="1" style="width: 8%;">
            </colgroup>
            <tr>
                <th><h2><fmt:message key="title"/></h2></th>
                <th><h2><fmt:message key="description"/></h2></th>
                <th><h2><fmt:message key="price"/></h2></th>
                <th><h2><fmt:message key="date"/></h2></th>
                <th><h2><fmt:message key="time"/></h2></th>
            </tr>
            <c:forEach var="exhibition" items="${exhibitionsList}">
                <tr>
                    <th>${exhibition.title}</th>
                    <th>${exhibition.description}</th>
                    <th>${exhibition.price}</th>
                    <th>${exhibition.startDate} - ${exhibition.endDate}</th>
                    <th>${exhibition.openingTime} - ${exhibition.closingTime}</th>
                </tr>
            </c:forEach>
        </table>

        <%--            <p><fmt:message key="filterBy"/>: <br>--%>
        <%--                <label><fmt:message key="master"/> <input type="radio" name="filterMethod" value="filterByMaster"/></label>--%>
        <%--                <br>--%>
        <%--                <label><fmt:message key="service"/> <input type="radio" name="filterMethod" value="filterByService"/></label></p>--%>
        <%--            <label><fmt:message key="filterParameter"/> : <input type="text" name="filter"/></label>--%>
        <%--            <button name="submit" type="submit"><fmt:message key="submit"/></button>--%>
        <%--        </form>--%>
        <%--        <form name="getList" action="app" method="post" >--%>
        <%--            <input type="hidden" name="command" value="exhibitionsList"/>--%>
        <%--        </form>--%>
        <%--        <script>--%>
        <%--            document.getList.submit();--%>
        <%--        </script>--%>
        <%--        <c:forEach var="exhibition" items="${requestScope.exhibitionsList}">--%>
        <%--            <br/>--%>
        <%--            ${exhibition.title}--%>
        <%--            <br/>--%>
        <%--        </c:forEach>--%>
    </div>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>
