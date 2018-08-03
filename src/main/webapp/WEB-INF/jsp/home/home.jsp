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
	
    
    <h2>Tarefas em aberto</h2>
	    <c:if test="${not empty notFinishedTasks}">
			<c:import url="notFinishedTasks.jsp" />
		</c:if>
	    <br/>
    <h2>Tarefas finalizadas</h2>
    <c:if test="${not empty finishedTasks}">
		<c:import url="finishedTasks.jsp" />
	</c:if>
    
    <c:import url="../commons/endBody.jsp" />