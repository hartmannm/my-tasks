<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <c:import url="../commons/head.jsp" />
    
	<c:if test="${not empty successMessage}">
		<c:import url="../commons/msgSuccessAlert.jsp" />
	</c:if>
    
    ${session.user.name} - ${session.user.id}
    
    <c:import url="../commons/endBody.jsp" />