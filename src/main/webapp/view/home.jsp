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
<jsp:include page="fragments/header.jsp"/>
<div>
    <h1 class="center">My info</h1>
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
    <div>
        <strong><fmt:message key="firstName"/></strong>
    </div>
    <input name="login" type="text" value="${account.firstName}" readonly/>
    <br>
<%--<div class="center">--%>
<%--    <h1>Purchase history</h1>--%>
<%--    <div>--%>
<%--        <form action="${contextPath}/app" method="post">--%>
<%--            <input type="hidden" name="command" value="getAccountOrders"/>--%>
<%--            <table class="center" id="tableCenter">--%>
<%--                <colgroup>--%>
<%--                    <col span="1" style="width: 600px;">--%>
<%--                    <col span="1" style="width: 150px;">--%>
<%--                    <col span="1" style="width: 110px;">--%>
<%--                    <col span="1" style="width: 110px;">--%>
<%--                    <col span="1" style="width: 120px;">--%>
<%--                    <col span="1" style="width: 150px;">--%>
<%--                    <col span="1" style="width: 120px;">--%>
<%--                </colgroup>--%>
<%--                <tr>--%>
<%--                    <th><h3><fmt:message key="title"/></h3></th>--%>
<%--                    <th><h3><fmt:message key="date"/></h3></th>--%>
<%--                    <th><h3><fmt:message key="time"/></h3></th>--%>
<%--                    <th><h3><fmt:message key="halls"/></h3></th>--%>
<%--                    <th><h3><fmt:message key="price"/>, <fmt:message key="uah"/></h3></th>--%>
<%--                    <th><h3><fmt:message key="quantity"/></h3></th>--%>
<%--                    <th><h3><fmt:message key="total"/></h3></th>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td>${exhibition.title}</td>--%>
<%--                    <td>${exhibition.startDate} - ${exhibition.endDate}</td>--%>
<%--                    <td>${exhibition.openingTime} - ${exhibition.closingTime}</td>--%>
<%--                    <td>--%>
<%--                        ${exhibition.exhibitionHalls}--%>
<%--                    </td>--%>
<%--                    <td><input name="exhibitionPrice" type="hidden" value="${exhibition.price}">${exhibition.price}</td>--%>
<%--                    <td><input onchange="calculateBill()" type="number" name="quantity" value="0" min="1" max="10"--%>
<%--                               onkeydown="return false"/></td>--%>
<%--                    <td><input type="number" name="bill" readonly></td>--%>
<%--                    <td style="border: none">--%>
<%--                        <c:if test="${not empty exhibition}">--%>
<%--                            <button style="width: 130px" type="submit" name="exhibitionId" value="${exhibition.id}">--%>
<%--                                <fmt:message key="buyTickets"/></button>--%>
<%--                        </c:if>--%>
<%--                        <br><br>--%>
<%--                        <button style="width: 130px"><a class="linkButton" href="${contextPath}/view/index.jsp"><fmt:message--%>
<%--                                key="cancel"/></a></button>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </table>--%>
<%--            <input type="hidden" value="${exhibition}">--%>
<%--        </form>--%>
<%--    </div>--%>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
