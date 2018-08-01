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
	
    
    <h2>Tarefas Passadas</h2>
    <c:if test="${not empty pastTasks}">
		<c:import url="pastTasksTable.jsp" />
	</c:if>
    <br/>
    <h2>Tarefas para hoje</h2>
    <c:if test="${not empty presentTasks}">
		<c:import url="presentTasksTable.jsp" />
	</c:if>
    <br/>
    <h2>Tarefas futuras</h2>
    <c:if test="${not empty futureTasks}">
		<c:import url="futureTasksTable.jsp" />
	</c:if>
    
    <c:import url="../commons/endBody.jsp" />