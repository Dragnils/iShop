<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="java-classes" uri="/WEB-INF/tags.tld"%>
<java-classes:static /><br>
<br>
<hr>

<-- JSP 2.0 --> <br>
<java-classes:static1 /><br>
<br>
<hr>
<java-classes:attr condition="true" /><br>
<java-classes:attr condition="false" /><br>
<java-classes:attr condition="${2 > 1 }" /><br>  <!--Expression Language -->
<java-classes:attr condition="<%=2 < 1 %>" /><br> <!-- jsp expression -->

<br>
<hr>

<-- JSP 2.0 --> <br>
<java-classes:attr1 condition="true" /><br>
<java-classes:attr1 condition="false" /><br>
<java-classes:attr1 condition="${2 > 1 }" /><br>  <!--Expression Language -->
<java-classes:attr1 condition="<%=2 < 1 %>" /><br> <!-- jsp expression -->

<hr>

<java-classes:h>h6</java-classes:h>
<java-classes:h type="h5">h5</java-classes:h>
<java-classes:h type="h4">h4</java-classes:h>
<java-classes:h type="h3">h3</java-classes:h>
<java-classes:h type="h2">h2</java-classes:h>
<java-classes:h type="h1">h1</java-classes:h>
<java-classes:h type="h0">h6</java-classes:h>

<br>
<hr>

<-- JSP 2.0 --> <br>
<java-classes:h1>h6</java-classes:h1>
<java-classes:h1 type="h5">h5</java-classes:h1>
<java-classes:h1 type="h4">h4</java-classes:h1>
<java-classes:h1 type="h3">h3</java-classes:h1>
<java-classes:h1 type="h2">h2</java-classes:h1>
<java-classes:h1 type="h1">h1</java-classes:h1>
<java-classes:h1 type="h0">h6</java-classes:h1>

<hr>

<java-classes:loop count="-2">NULL</java-classes:loop><br>
<java-classes:loop count="3"> 5 </java-classes:loop><br>
<java-classes:loop count="${ 1 + 5 }"> ${ 1 + 2 } </java-classes:loop><br> <!--Expression Language -->
<java-classes:loop count="<%=1+4 %>"> <br><!-- jsp expression -->
    <java-classes:attr condition="${2 > 1 }" />  <!--Expression Language -->
</java-classes:loop><br>

<br>
<br>
<hr>

<-- JSP 2.0 --> <br>
<java-classes:loop1 count="-2">NULL</java-classes:loop1><br>
<java-classes:loop1 count="3"> 5 </java-classes:loop1><br>
<java-classes:loop1 count="${ 1 + 5 }"> ${ 1 + 2 } </java-classes:loop1><br> <!--Expression Language -->
<java-classes:loop1 count="<%=1+4 %>"> <br><!-- jsp expression -->
    <java-classes:attr1 condition="${2 > 1 }" />  <!--Expression Language -->
</java-classes:loop1><br>

<br>
<br>
<hr>
<java-classes:uppercase>This is test!</java-classes:uppercase> <br>

<br>
<hr>
<-- JSP 2.0 --> <br>
<java-classes:uppercase1>This is test!</java-classes:uppercase1>