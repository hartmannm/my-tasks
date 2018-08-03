<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<form method="POST" action="${linkTo[TaskController].register}">
	<!--tarefa-->
	<div>
		<input type="hidden" name="task.id" value="${task.id}">
	</div>
	<div class="input-field col s12">
		<label for="task.name">Tarefa</label>
		<input type="text" name="task.name" value="${task.name}">
		<span>${errors.from('task.name')}</span>
	</div>
	<!--data-->
	<div class="input-field col s12">
		<input type="date" name="task.date" value="${task.date}"> 
		<label for="task.date">Data</label>
		<span>${errors.from('task.date')}</span>
	</div>
	<!--horario-->
	<div class="input-field col s12">
		<input type="time" name="task.hour" value="${task.hour}"> 
		<label for="task.hour">Horário</label>
		<span>${errors.from('task.hour')}</span>
	</div>
	<!--observações-->
	<div class="input-field col s12">
		<label for="task.details">Observações</label>
		<textarea name="task.details" rows="3" class="materialize-textarea">${task.details}</textarea>
		<span>${errors.from('task.details')}</span>
	</div>

	<div>
		<button type="submit" class="btn">
			Cadastrar
		</button>
		<button type="reset" class="btn red darken-4">
			Limpar
		</button>
		<c:if test="${not empty task.id}">
			<a href="${linkTo[HomeController].home}" class="btn amber darken-3">Cancelar</a>
		</c:if>
	</div>
</form>