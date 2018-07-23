<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <c:import url="../commons/head.jsp" />
	
	<c:if test="${not empty errorMessage}">
		<c:import url="../commons/msgErrorAlert.jsp" />
	</c:if>

	<c:import url="form.jsp" />

    <c:import url="../commons/endBody.jsp" />