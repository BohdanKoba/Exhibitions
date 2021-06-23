<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="addExhibition"/></title>
    <jsp:include page="/editStyle/pagestyle.jsp"/>
    <style>
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
        }
    </style>
</head>
<body>
<jsp:include page="/view/fragments/header.jsp"/>
<div id="addExhibition">
    <form action="${contextPath}/app" method="post" class="form-style">
        <input type="hidden" name="command" value="addExhibition"/>
        <div>
            <div>
                <strong><fmt:message key="title"/></strong>
            </div>
            <textarea id="titleInput" name="title" minlength="2" maxlength="255" required></textarea>
        </div>
        <br>
        <div>
            <div>
                <strong><fmt:message key="description"/></strong>
            </div>
            <textarea id="descriptionInput" name="description" minlength="150" maxlength="1024" required></textarea>
        </div>
        <br>
        <div>
            <div>
                <strong><fmt:message key="price"/></strong>
            </div>
            <input name="price" type="number" min="100" max="500" required/>
        </div>
        <br>
        <div>
            <div>
                <strong><fmt:message key="date"/></strong>
            </div>
            <fmt:message key="from"/>
            <input id="dateFrom" name="dateFrom" type="date" onclick="dateFromLimits()" oninput="enableDateTo()"
                   required onkeydown="return false"/>
            <fmt:message key="to"/>
            <input id="dateTo" name="dateTo" type="date" onclick="dateToLimits()" onchange="enableSetHalls()" disabled
                   required onkeydown="return false"/>
        </div>
        <br>
        <div>
            <div>
                <strong><fmt:message key="time"/></strong>
            </div>
            <fmt:message key="from"/>
            <input name="timeFrom" type="time" required/>
            <fmt:message key="to"/>
            <input name="timeTo" type="time" required/>
        </div>
        <div>
            <strong><fmt:message key="setHalls"/></strong>
            <br>
            <select name="halls" id="halls" multiple disabled>
                <c:forEach var="hall" items="${halls}">
                    <option value="${hall.id}"/>${hall.hallName}</option>
                </c:forEach>
            </select>
        </div>
        <br>
        <input style="width: 100px" type="submit" value="<fmt:message key="add"/>"/>
        <button style="width: 100px"><a class="linkButton" href="${contextPath}/view/index.jsp"><fmt:message key="cancel"/></a>
        </button>
    </form>
</div>
<script>
    function enableDateTo() {
        document.getElementById("dateTo").disabled = false;
    }
</script>
<script>
    function enableSetHalls() {
        let dateFrom = document.getElementById("dateFrom").value;
        let dateTo = document.getElementById("dateTo").value;
        import("${contextPath}/app?command=getAvailableHalls&dateFrom=" + dateFrom + "&dateTo=" + dateTo);
        document.getElementById("halls").disabled = false;
    }
</script>
<script>
    function dateFromLimits() {
        let dateFrom = document.getElementById("dateFrom");
        let date = new Date();
        let fDate = date.getFullYear() + '-' + String(date.getMonth() + 1).padStart(2, '0') + '-' + String(date.getDate()).padStart(2, '0');
        date.setMonth(date.getMonth() + 6);
        let tDate = date.getFullYear() + '-' + String(date.getMonth() + 1).padStart(2, '0') + '-' + String(date.getDate()).padStart(2, '0');
        dateFrom.min = fDate;
        dateFrom.max = tDate;
    }
</script>
<script>
    function dateToLimits() {
        let dateTo = document.getElementById("dateTo");
        let date = new Date(document.getElementById("dateFrom").value);
        let minDate = new Date(date);
        minDate.setDate(date.getDate() + 13);
        dateTo.min = minDate.getFullYear() + '-' + String(minDate.getMonth() + 1).padStart(2, '0') + '-' + String(minDate.getDate()).padStart(2, '0');
        date.setMonth(date.getMonth() + 3);
        dateTo.max = date.getFullYear() + '-' + String(date.getMonth() + 1).padStart(2, '0') + '-' + String(date.getDate()).padStart(2, '0');
    }
</script>
<jsp:include page="/view/fragments/footer.jsp"/>
</body>
</html>
