<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form method="POST" action="${linkTo[UserController].cadastro}">
	<c:if test="${not empty errorMessage}">
		<c:import url="../commons/msgErrorAlert.jsp" />
	</c:if>

	<!--nome de usuário-->
	<div class="form-group">
		<label for="nome">Nome de usuário</label>
		<div class="input-group">
			<input type="text" class="form-control" name="user.name" value="${user.name}">
			<span class="error">${errors.from('user.name')}</span>
		</div>
	</div>
	<!--email-->
	<div class="form-group">
		<label for="email">Email</label>
		<div class="input-group">
			<input type="email" class="form-control" name="user.email" value="${user.email}"> 
			<span class="error">${errors.from('user.email')}</span>
		</div>
	</div>
	<!--senha-->
	<div class="form-group">
		<label for="user.password">Senha</label>
		<div class="input-group">
			<input type="password" class="form-control" name="user.password" />
			<span class="error">${errors.from('user.password')}</span>
		</div>
	</div>
	<!--repetição de senha-->
	<div class="form-group">
		<label for="user.passwordConfirm">Repita a senha</label>
		<div class="input-group">
			<input type="password" class="form-control" name="user.passwordConfirm" />
			<span class="error">${errors.from('user.passwordConfirm')}</span>
		</div>
	</div>

	<div class="row justify-content-start">
		<button type="submit" class="btn btn-primary">
			Cadastrar
		</button>
		<button type="reset" class="btn btn-danger">
			Limpar
		</button>
	</div>
</form>