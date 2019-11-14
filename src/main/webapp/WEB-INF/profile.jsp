<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="row profiles">
    <div id="profileContainer" class="col-xs-12">
        <c:if test="${fn:length(profiles) == 0}"> <%--  если длина объекта профелей в данном случае выступает коллекция равняется нулю, то  "Профили не найдены"--%>
            Профили не найдены
        </c:if>
        <c:forEach var="profile" items="${profiles }"> <%-- иначе проходимся foreach по каждому профилю  --%>
            <div class="panel panel-default profile-item"> <%-- создаем объект панели  отображения текущего профиля   --%>
                <img src="${profile.smallPhoto }" class="photo">
                <h3>${profile.fullName }</h3>
            </div>
        </c:forEach>
    </div>
    <c:if test="${page.number < page.totalPages - 1}"> <%-- делаем проверку if --%>
        <div id="loadMoreContainer" class="col-xs-12 text-center"> <%-- добавляем еще блок   --%>
            <a href="#" class="btn btn-primary">Загрузить еще</a> <%-- если не все профили отображаются можно отобразить кнопкой "Еще"  --%>
        </div>
    </c:if>
</div>