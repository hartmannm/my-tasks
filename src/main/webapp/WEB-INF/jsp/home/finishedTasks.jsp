<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <table border="1">
	    <thead>
	    	<tr>
	    		<th>Tarefa</th>
		    	<th>Data</th>
		    	<th>Hora</th>
		    	<th>Observações</th>
		    	<th>Status</th>
		    	<th>Opções</th>
	    	</tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${finishedTasks}" var="task">
	    		<tr>
	    			<td>${task.name}</td>
	    			<td>
	    				<javatime:format value="${task.date}" pattern="dd/MM/yyyy" />
	    			</td>
	    			<td>${task.hour}</td>
	    			<td>${task.details}</td>
	    			<td>Em aberto</td>
	    			<td>
	    				<a href="${linkTo[TaskController].edit(task.id)}">Editar</a>
	    				<a href="${linkTo[TaskController].remove(task.id)}">Excluir</a>
	    			</td>
	    		</tr>
	    	</c:forEach>
	    </tbody>
	</table>
