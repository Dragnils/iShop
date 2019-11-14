<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:forEach var="p" items="${products }"> <%--проходимся по коллекции продуктов, записываем в переменную "p"  --%>
    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 col-xlg-2"> <%--строим блок информации   --%>
        <div id="product${p.id }" class="panel panel-default product"><%--строим блок продуктов  --%>
            <h2>${fn:toUpperCase(p.name) }</h2><%--приводим его имя к верхнему регистру  --%>
            <div class="price">Price: <fmt:formatNumber value="${p.price }" type="currency" currencyCode="USD" /> <%--указываем цену , для того чтобы сформатировать цену используем formatNumber из библиотеки fmt  --%>
            </div>
            <div class="created">Created: <fmt:formatDate value="${p.created }" pattern="yyyy-MM-dd"/>  <%--время создания --%>
            </div>
            <div class="created">Created: <fmt:formatDate value="${p.created }" dateStyle="long" type="date"/>
            </div>
        </div>
    </div>
</c:forEach>