<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <form method="POST" action="${linkTo[TaskController].register}">
	<!--tarefa-->
	<div>
		<input type="hidden" name="task.id" value="${task.id}">
	</div>
	<div>
		<label for="task.name">Tarefa</label>
		<input type="text" name="task.name" value="${task.name}">
		<span>${errors.from('task.name')}</span>
	</div>
	<!--data-->
	<div>
		<label for="task.date">Data</label>
		<input type="date" name="task.date" value="${task.date}"> 
		<span>${errors.from('task.date')}</span>
	</div>
	<!--horario-->
	<div>
		<label for="task.hour">Horário</label>
		<input type="time" name="task.hour" value="${task.hour}"> 
		<span>${errors.from('task.hour')}</span>
	</div>
	<!--observações-->
	<div>
		<label for="task.details">Observações</label>
		<textarea name="task.details" rows="3">${task.details}</textarea>
		<span>${errors.from('task.details')}</span>
	</div>

	<div>
		<button type="submit">
			Cadastrar
		</button>
		<button type="reset">
			Limpar
		</button>
		<c:if test="${not empty task.id}">
			<a href="${linkTo[HomeController].home}">Cancelar</a>
		</c:if>
	</div>
</form>