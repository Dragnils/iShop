<%@ page import="net.devstudy.model.Model"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
    model=${model} <!-- выводится метод toString  -->
<br>
    model.list=${model.list} <!-- обращаемся к методу getList() класса Model, на основании bean -->
<br>
    foreach1=
            <% Model model = (Model) request.getAttribute("model"); //считываем из request атрибут model
                for(String item : model.getList()) { // вставляем в цикл %>
            <%=item %> <!-- выводим значение переменной через jsp expression-->
            ||
            <%
                }
            %> <!-- 1 способ-->
<br>
    foreach2=
            <% model = (Model) request.getAttribute("model");
                for(String item : model.getList()) {
                    pageContext.setAttribute("item", item); // чтобы превратить в  Expression Language
            %>
            ${item }<!-- выводим значение переменной через Expression Language-->
            ||
            <%
                }
            %> <!-- 2 способ-->
<br>
        foreach3=${model.data} <!-- 3 способ,  выводим с помощью Expression Language метод getData класса Model-->
<br>