<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"  trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
<% if(session.getAttribute("CURRENT_SHOPPING_CART") !=null) {%> <!-- проверяем что в сессии существует  атрибут с именем CURRENT_SHOPPING_CART-->
Total count = ${CURRENT_SHOPPING_CART.totalCount}<br>
Products: <br>${CURRENT_SHOPPING_CART.view}
<% } else {%>
Shopping cart is null
<% } %>

--%>

<c:choose>
    <c:when test="${CURRENT_SHOPPING_CART != null}">
        Total count = ${CURRENT_SHOPPING_CART.totalCount}<br>
        Products: <br>
        <%-- проходится по коллекции Collection<ShopingCartItem> getItems() из класса ShoppingCart, в  ShopingCartItem есть idProduct и count--%>
        <c:forEach var="it" items="${CURRENT_SHOPPING_CART.items}">
            ${it.idProduct}-&gt;${it.count} <br>
        </c:forEach>
    </c:when>
    <c:otherwise>
        Shopping cart is null
    </c:otherwise>

</c:choose>

