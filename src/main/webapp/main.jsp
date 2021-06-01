<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title>Exhibitions</title>
</head>
<body>
<jsp:include page="common/header.jsp"/>
<br/>
<div style="display: flex; justify-content: space-between; margin: 0 20px;">
    <div>
        <h2><fmt:message key="availableExhibitions"/></h2>
        <form action="app" method="get">
            <input type="hidden" name="command" value="login" />
        </form>
    <%--            <c:forEach var="exhibition" items="${requestScope.exhibitionsList}">--%>
<%--            <br/>--%>
<%--            ${exhibition.title}--%>
<%--            <br/>--%>
            <%--            <div class="card border-dark mb-5" id="periodical-${periodical.id}">--%>
<%--                <div class="row no-gutters ">--%>
<%--                    <div class="col-md-8 text-white">--%>
<%--                        <div class="card-header card-title text-center">--%>
<%--                            <a href="<c:url value="/app/periodical?periodicalId=${periodical.id}"/>">--%>
<%--                                <h3><c:out value="${periodical.name}"/></h3>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <div class="card-body bg-primary accordion" id="accordion-${periodical.id}">--%>
<%--                            <div class="card-text text-center" id="heading-${periodical.id}">--%>
<%--                                <button class="btn btn-link" type="button" data-toggle="collapse"--%>
<%--                                        data-target="#collapse-${periodical.id}"--%>
<%--                                        aria-expanded="false" aria-controls="collapse-${periodical.id}">--%>
<%--                                    <fmt:message key="periodical.description"/>&nbsp;--%>
<%--                                    <i class="fa fa-caret-square-o-down fa-lg" aria-hidden="true"></i>--%>
<%--                                </button>--%>
<%--                            </div>--%>
<%--                            <div id="collapse-${periodical.id}" class="collapse" aria-labelledby="heading-${periodical.id}"--%>
<%--                                 data-parent="#accordion-${periodical.id}">--%>
<%--                                <p class="card-text"><c:out value="${periodical.description}"/></p>--%>
<%--                            </div>--%>
<%--                        </div>--%>

<%--                        <ul class="bg-primary text-white list-group list-group-flush">--%>
<%--                            <li class="list-group-item bg-primary">--%>
<%--                                ${exhibition.title}--%>
<%--                            </li>--%>
<%--&lt;%&ndash;                            <li class="list-group-item bg-primary">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <fmt:message key="periodical.frequency"/>:&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <c:out value="${periodical.frequency.name}"/> - <c:out value="${periodical.frequency.meaning}"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <li class="list-group-item bg-primary">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <fmt:message key="periodical.publisher"/>: <c:out value="${periodical.publisher.name}"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <li class="list-group-item bg-primary">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <fmt:message key="periodical.price"/>: <c:out value="${periodical.price} $"/></li>&ndash;%&gt;--%>
<%--                        </ul>--%>
<%--                        <c:if test="${!sessionScope.user.isAdmin() and periodical.status ne PeriodicalStatus.SUSPENDED}">--%>
<%--                            <div class="card-footer d-flex justify-content-sm-center justify-content-lg-end ">--%>
<%--                                <form accept-charset="UTF-8" role="form" method="post"--%>
<%--                                      action="<c:url value="/app/cart/add"/>">--%>
<%--                                    <!-- Button trigger modal -->--%>
<%--                                    <div class="input-group ">--%>
<%--                                        <input type="hidden" class="form-control" name="periodicalId"--%>
<%--                                               value="${periodical.id}">--%>
<%--                                        <button type="button" class="btn btn-info btn-lg" data-toggle="modal"--%>
<%--                                                data-target="#modal-${periodical.id}">--%>
<%--                                            <i class="fa fa-chevron-circle-right fa-lg" aria-hidden="true">&nbsp;</i>--%>
<%--                                            <fmt:message key="periodical.subscribe"/>--%>
<%--                                        </button>--%>
<%--                                    </div>--%>
<%--                                </form>--%>
<%--                            </div>--%>
<%--                        </c:if>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>



















<%--        <form action="app" method="post">--%>
<%--            <input type="hidden" name="command" value="exhibitionsList"/>--%>
<%--            <label><input name="command" value="getServiceCatalog" type="hidden"/></label>--%>
<%--&lt;%&ndash;            <label><fmt:message key="sortBy"/>: <fmt:message key="name"/><input name="sortMethod" value="sortByName" type="radio" checked/></label>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <label><fmt:message key="rate"/><input name="sortMethod" value="sortByRate" type="radio"/></label>&ndash;%&gt;--%>
<%--            <br>--%>

<%--            <p><fmt:message key="filterBy"/>: <br>--%>
<%--                <label><fmt:message key="master"/> <input type="radio" name="filterMethod" value="filterByMaster"/></label>--%>
<%--                <br>--%>
<%--                <label><fmt:message key="service"/> <input type="radio" name="filterMethod" value="filterByService"/></label></p>--%>
<%--            <label><fmt:message key="filterParameter"/> : <input type="text" name="filter"/></label>--%>
<%--            <button name="submit" type="submit"><fmt:message key="submit"/></button>--%>
<%--        </form>--%>
    </div>
<%--    <c:choose>--%>
<%--        <c:when test="${userLoggedIn}">--%>
<%--            <a href="/Servlet?command=homepage"><fmt:message key="homePage"/></a>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <div>--%>
<%--                <form action="/app" method="post">--%>
<%--                    <input type="hidden" name="command" value="login"/>--%>
<%--                    <label><input name="username" type="text" placeholder="<fmt:message key="username"/>"/></label>--%>
<%--                    <br>--%>
<%--                    <label><input name="password" type="password" placeholder="<fmt:message key="password"/>"/></label>--%>
<%--                    <br>--%>
<%--                    <button type="submit"><fmt:message key="login"/> </button>--%>
<%--                </form>--%>
<%--                <p style="color: #ff0000">${errorMessage}</p>--%>
<%--                <p style="margin-top: 100px;"><a href="/Servlet?command=getAllFeedback"><fmt:message key="feedbacks"/></a></p>--%>
<%--            </div>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>
