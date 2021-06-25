<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="buyTickets"/></title>
    <jsp:include page="/editStyle/pagestyle.jsp"/>
</head>
<jsp:include page="../fragments/header.jsp"/>
<br>
<h2 class="center"><fmt:message key="createOrder"/></h2>
<br>
<div class="center">
    <select id="select-exhibitions" onchange="getExhibition()">
        <option disabled selected><fmt:message key="chooseExhibition"/></option>
        <c:forEach var="exhibition" items="${exhibitions}">
            <option value="${exhibition.id}">${exhibition.title}</option>
        </c:forEach>
    </select>
    <form name="selectedExhibition" action="${contextPath}/app" method="get">
        <input type="hidden" name="command" value="getOrderExhibition"/>
        <input type="hidden" id="exhibitionId" name="id">
    </form>
</div>
<div>
    <form action="${contextPath}/app" method="post">
        <input type="hidden" name="command" value="buyTickets"/>
        <input type="hidden" name="accountId" value="${account.id}">
        <input type="hidden" name="exhibitionId" value="${exhibition.id}">
        <table class="center" id="tableCenter">
            <tr>
                <th><h3><fmt:message key="title"/></h3></th>
                <th><h3><fmt:message key="date"/></h3></th>
                <th><h3><fmt:message key="time"/></h3></th>
                <th><h3><fmt:message key="price"/>, <fmt:message key="uah"/></h3></th>
                <th><h3><fmt:message key="quantity"/></h3></th>
                <th><h3><fmt:message key="total"/></h3></th>
            </tr>
            <tr>
                <td>${exhibition.title}</td>
                <td>${exhibition.startDate} - ${exhibition.endDate}</td>
                <td>${exhibition.openingTime} - ${exhibition.closingTime}</td>
                <td><input name="exhibitionPrice" type="hidden" value="${exhibition.price}">${exhibition.price}</td>
                <td><input onchange="calculateBill()" type="number" name="quantity" value="0" min="1" max="10"
                           onkeydown="return false"/></td>
                <td><input type="number" name="bill" readonly></td>
                <td style="border: none">
                    <c:if test="${not empty exhibition}">
                        <button style="width: 130px" type="submit" name="exhibitionId" value="${exhibition.id}">
                            <fmt:message key="buyTickets"/></button>
                    </c:if>
                    <br><br>
                    <button style="width: 130px"><a class="linkButton" href="${contextPath}/view/index.jsp"><fmt:message
                            key="cancel"/></a></button>
                </td>
            </tr>
        </table>
        <input type="hidden" value="${exhibition}">
    </form>
</div>
<script>
    function getExhibition() {
        document.getElementById("exhibitionId").value = document.getElementById("select-exhibitions").value;
        document.selectedExhibition.submit();
    }
</script>
<script>
    function calculateBill() {
        let price = document.getElementsByName("exhibitionPrice")[0].value;
        let quantity = document.getElementsByName("quantity")[0].value;
        let bill = document.getElementsByName('bill')[0];
        bill.value = price * quantity;
    }
</script>
</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
