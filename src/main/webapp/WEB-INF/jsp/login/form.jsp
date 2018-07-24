<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form method="POST" action="${linkTo[LoginController].login}">
	<c:if test="${not empty errorMessage}">
		<c:import url="../commons/msgErrorAlert.jsp" />
	</c:if>

	<div class="form-group">
		<label for="user.email">Email</label>
		<div class="input-group">
			<input type="email" class="form-control" name="user.email" value="${user.email}"> 
			<span for="user.email">${errors.from('user.email')}</span>
		</div>
	</div>
	<div class="form-group">
		<label for="user.password">Senha</label>
		<div class="input-group">
			<input type="password" class="form-control" name="user.password"> 
			<span for="user.password">${errors.from('user.password')}</span>
		</div>
	</div>

	<div class="row">
		<button type="submit" class="btn btn-primary">
			Entrar
		</button>
	</div>
</form>
<div class="row">
	Ainda não tem uma conta? 
	<a href="${linkTo[UserController].cadastro}">
		<span class="strong">Criar conta</span>
	</a>
</div>