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
</head>
<body>
<jsp:include page="../fragments/header.jsp"/>
<div id="addExhibition">
    <form action="app" method="post" class="form-style">
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
            <input name="dateFrom" type="date" required/>
            <fmt:message key="to"/>
            <input name="dateTo" type="date" required/>
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
        <br>
        <input style="width: 100px" type="submit" value="<fmt:message key="add"/>"/>
        <button style="width: 100px"><a class="linkButton" href="../../exhibitions.jsp"><fmt:message key="cancel"/></a></button>
    </form>
</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
