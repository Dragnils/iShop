<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"  trimDirectiveWhitespaces="true" %>

<% if(session.getAttribute("CURRENT_SHOPPING_CART") !=null) {%> <!-- проверяем что в сессии существует  атрибут с именем CURRENT_SHOPPING_CART-->
Total count = ${CURRENT_SHOPPING_CART.totalCount}<br>
Products: <br>${CURRENT_SHOPPING_CART.view}
<% } else {%>
Shopping cart is null
<% } %>