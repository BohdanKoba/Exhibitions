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
<body>
<jsp:include page="fragments/header.jsp"/>
<c:if test="${empty exhibitions}">
    <c:import url="/app?command=getExhibitions"/>
</c:if>
<br><br>
<select id="select-exhibitions" name="" onchange="myFunction()">
    <option disabled selected>Choose Exhibition</option>
    <c:forEach var="exhibition" items="${exhibitions}">
        <option value="${exhibition.id}">${exhibition.title}</option>
    </c:forEach>
</select>
<form name="selectedExhibition" action="${contextPath}/app" method="post">
    <input type="hidden" name="command" value="maapExhibition"/>
    <input type="hidden" id="exhibitionId" name="id" value="">
</form>

<h2 class="center">My purchase</h2>
<%--<form name="purchase" action="${contextPath}/app" method="post">--%>
<%--    <input type="hidden" name="command" value="buyTickets"/>--%>
<%--    <input id="date" type="text" value="${exhibition.title}" readonly>--%>
<%--    <input id="time" type="text" value="${exhibition.title}" readonly>--%>
<%--    <input id="price" type="text" value="${exhibition.title}" readonly>--%>
<%--    <input id="date" type="text" value="${exhibition.title}" readonly>--%>
<%--    <input id="time" type="text" value="${exhibition.title}" readonly>--%>
<%--    <input id="price" type="text" value="${exhibition.title}" readonly>--%>
<%--    <td style="border: none"><input onchange="calculateBill()" name="quantity" value="0" type="number"pattern="[1-10]" min="1" max="10"/></td>--%>
<%--</form>--%>
<%--<form name="purchase" action="${contextPath}/app" method="post">--%>
<%--    <input type="hidden" name="command" value="mapExhibition"/>--%>
<%--    <input name="exhibitionId" id="title" type="text" value="" >--%>
<%--    <button hidden type="submit" name="exhibitionId" value=""></button>--%>
<%--</form>--%>


<%--<script>--%>
<%--    function myFunction() {--%>
<%--        let x = document.getElementById("select-exhibitions").value;--%>
<%--        document.purchase.getElementById("title").value = x;--%>
<%--        document.purchase.submit();--%>
<%--        // document.getElementById("title").value = x;--%>
<%--        // document.getElementById("title").value = x;--%>
<%--        // document.getElementById("title").value = x;--%>
<%--    }--%>
<%--</script>--%>

<script>
    function myFunction() {
        document.getElementById("exhibitionId").value = document.getElementById("select-exhibitions").value;
        document.selectedExhibition.submit();
    }
</script>


<%--<select id="exhibitionsList">--%>
<%--    <c:forEach var="exhibition" items="${exhibitions}">--%>
<%--        <option value="${exhibition.title}">${exhibition.title}</option>--%>
<%--    </c:forEach>--%>
<%--</select>--%>

<%--<input id="title" type="text" value="">--%>

<%--<script>--%>
<%--    function myFunction() {--%>
<%--        let exhibition = document.getElementById("exhibitionsList").value;--%>
<%--        document.getElementById("title").value = exhibition;--%>
<%--    }--%>
<%--</script>--%>


<%--<div>--%>
<table id="tableCenter">
    <%--        <colgroup>--%>
    <%--            <col span="1" style="width: 320px;">--%>
    <%--            <col span="1" style="width: 130px;">--%>
    <%--            <col span="1" style="width: 90px;">--%>
    <%--            <col span="1" style="width: 120px;">--%>
    <%--            <col span="1" style="width: 150px;">--%>
    <%--        </colgroup>--%>
    <tr>
        <th><h3><fmt:message key="title"/></h3></th>
        <th><h3><fmt:message key="date"/></h3></th>
        <th><h3><fmt:message key="time"/></h3></th>
        <th><h3><fmt:message key="price"/>, <fmt:message key="uah"/></h3></th>
        <th><h3><fmt:message key="quantity"/></h3></th>
    </tr>

<%--        <table>--%>
<%--            <tr>--%>
<%--                <th><h3>price</h3></th>--%>
<%--                <th><h3>count</h3></th>--%>
<%--                <th><h3>sum</h3></th>--%>
<%--            </tr>--%>
<%--            <form name="purchase" action="${contextPath}/app" method="post">--%>
<%--                <input type="hidden" name="command" value="buyTickets"/>--%>
<%--                <tr>--%>
<%--                    <td><input name="price" type="hidden" value="50">5</td>--%>
<%--                    <td><input onchange="calculateBill()" name="quantity" value="0" type="number" onkeydown="return false"/></td>--%>
<%--                    <td><input type="number" name="bill" readonly></td>--%>
<%--                    <button type="submit" >enrter</button>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </form--%>
<%--        </table>--%>



    <form name="purchase" action="${contextPath}/app" method="post">
        <input type="hidden" name="command" value="buyTickets"/>
        <tr>
            <td>${exhibition.title}</td>
            <td>${exhibition.startDate} - ${exhibition.endDate}</td>
            <td>${exhibition.openingTime} - ${exhibition.closingTime}</td>
            <td><input name="exhibitionPrice" type="hidden" value="${exhibition.price}">${exhibition.price}</td>
            <td><input onchange="calculateBill()" type="number" name="quantity" value="0" min="1" max="10" onkeydown="return false"/></td>
            <td><input type="number" name="bill" readonly></td>
            </td>
        </tr>
        <button style="width: 100px" type="submit" name="exhibitionId" value="${exhibition.id}">
            <fmt:message key="buyTickets"/></button>
    </form>
</table>
<button style="width: 100px"><a class="linkButton" href="index.jsp"><fmt:message key="cancel"/></a></button>
<script>
    function calculateBill() {
        let price = document.getElementsByName("exhibitionPrice")[0].value;
        let quantity = document.getElementsByName("quantity")[0].value;
        let bill = document.getElementsByName('bill')[0];
        bill.value = price * quantity;
    }
</script>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
