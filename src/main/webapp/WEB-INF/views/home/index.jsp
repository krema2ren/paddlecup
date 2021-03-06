<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<security:authorize access="!isAuthenticated()">
<spring:message code="label_home_index" htmlEscape="false" var="title"/>
<spring:message code="application_name" htmlEscape="false" var="app_name"/>
<p class="lead"><spring:message arguments="${app_name}" code="welcome_titlepane"/></p>
<p>User ${profile.userName} is logged in</p>
</security:authorize>