<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <title>$Authorization$</title>
     <style>
          <%@include file='WEB-INF/style/styleLocal.css' %>
          <%@include file='WEB-INF/style/styleIndex.css' %>
      </style>
    <fmt:setLocale value="${sessionScope.local}" />
    <fmt:setBundle basename="localization.local" var="loc" />
    <fmt:message bundle="${loc}" key="local.login" var="login" />
      <fmt:message bundle="${loc}" key="local.password" var="password" />
      <fmt:message bundle="${loc}" key="local.signIn" var="signIn" />
      <fmt:message bundle="${loc}" key="local.locbutton.name.ru"
                 var="ru_button" />
    <fmt:message bundle="${loc}" key="local.locbutton.name.en"
                 var="en_button" />
  </head>
  <body>
<form class="login" action="Controller" method="post">

    <input type="hidden" name="command" value="login" />

    <span>${login}</span>
    <input class="input" type="text" name="login" value="" />
    <span>${password}</span>
    <input class="input" type="password" name="password" value="" />

    <input class="submit" type="submit" value="${signIn}" />
  </form>



<div class="local">
  <form action="ControllerLocal" method="post">
    <input type="hidden" name="local" value="ru" />
    <input   class="local-button" type="submit" value="${ru_button}" />
  </form>

  <form action="ControllerLocal" method="post">
    <input type="hidden" name="local" value="en" />
      <input  class="local-button" type="submit" value="${en_button}" />
  </form>
</div>

  </body>
</html>
