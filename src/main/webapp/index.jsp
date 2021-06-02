<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>--%>

<%--<fmt:setLocale value="${language}"/>--%>
<%--<fmt:setBundle basename="resources"/>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<body>--%>
<%--<h2 style="text-align: center"><fmt:message key="availableExhibitions"/></h2>--%>

<%--&lt;%&ndash;<form action="app" method="post">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <label><input name="command" value="getServiceCatalog" type="hidden"/></label>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <label><fmt:message key="sortBy"/>: <fmt:message key="name"/><input name="sortMethod" value="sortByName" type="radio" checked/></label>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <label><fmt:message key="rate"/><input name="sortMethod" value="sortByRate" type="radio"/></label>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <br>&ndash;%&gt;--%>

<%--&lt;%&ndash;    <p><fmt:message key="filterBy"/>: <br>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <label><fmt:message key="master"/> <input type="radio" name="filterMethod" value="filterByMaster"/></label>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <br>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <label><fmt:message key="service"/> <input type="radio" name="filterMethod" value="filterByService"/></label></p>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <label><fmt:message key="filterParameter"/> : <input type="text" name="filter"/></label>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <button name="submit" type="submit"><fmt:message key="submit"/></button>&ndash;%&gt;--%>
<%--&lt;%&ndash;</form>&ndash;%&gt;--%>

<%--&lt;%&ndash;<table>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <c:forEach var="exhibition" items="${exhibitionsList}">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <th>${exhibition.title}</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <th>${exhibition.description}</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <th>${exhibition.price}</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </c:forEach>&ndash;%&gt;--%>
<%--&lt;%&ndash;</table>&ndash;%&gt;--%>

<%--&lt;%&ndash;<c:redirect url="/app?command=exhibitionsList"/>&ndash;%&gt;--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--<fmt:setLocale value="${language}"/>--%>
<%--<fmt:setBundle basename="resources"/>--%>
<!DOCTYPE html>
<html>
<%--<head>--%>
<%--    <title>Exhibitions</title>--%>
<%--</head>--%>
<body>
<%--<jsp:include page="common/header.jsp"/>--%>
<%--<br/>--%>
<%--<div style="display: flex; justify-content: space-between; margin: 0 20px;">--%>
<%--    <div>--%>
<%--        <h2><fmt:message key="availableExhibitions"/></h2>--%>
        <form id="getExhibitions" action="app" method="post">
            <input name="command" value="exhibitionsList" type="hidden"/>
        </form>
        <script>
            document.getElementById("getExhibitions").submit();
        </script>




<%--        <table>--%>
<%--            <c:forEach var="exhibition" items="${sessionScope.exhibitionsList}">--%>
<%--                <tr>--%>
<%--                    <th>${exhibition.title}</th>--%>
<%--                    <th>${exhibition.description}</th>--%>
<%--                    <th>${exhibition.price}</th>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </table>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<jsp:include page="common/footer.jsp"/>--%>
</body>
</html>