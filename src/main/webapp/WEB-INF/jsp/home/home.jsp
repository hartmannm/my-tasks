<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <c:import url="../commons/head.jsp" />
    
	<c:if test="${not empty successMessage}">
		<c:import url="../commons/msgSuccessAlert.jsp" />
	</c:if>
    <c:if test="${not empty alertMessage}">
		<c:import url="../commons/msgAlertAlert.jsp" />
	</c:if>
    
    <c:import url="pastTasks.jsp" />
    <br/>
    <c:import url="presentTasks.jsp" />
    <br/>
    <c:import url="futureTasks.jsp" />
    
    <c:import url="../commons/endBody.jsp" />