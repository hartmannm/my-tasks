<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form method="POST" action="${linkTo[UserController].register}">
	<c:if test="${not empty errorMessage}">
		<c:import url="../commons/msgErrorAlert.jsp" />
	</c:if>

	<!--nome de usuário-->
	<div>
		<label for="user.name">Nome de usuário</label>
		<input type="text" name="user.name" value="${user.name}">
		<span>${errors.from('user.name')}</span>
	</div>
	<!--email-->
	<div>
		<label for="user.email">Email</label>
		<input type="email" name="user.email" value="${user.email}"> 
		<span>${errors.from('user.email')}</span>
	</div>
	<!--senha-->
	<div>
		<label for="user.password">Senha</label>
		<input type="password" name="user.password" />
		<span>${errors.from('user.password')}</span>
	</div>
	<!--repetição de senha-->
	<div>
		<label for="user.passwordConfirm">Repita a senha</label>
		<input type="password" name="user.passwordConfirm" />
		<span>${errors.from('user.passwordConfirm')}</span>
	</div>

	<div>
		<button type="submit">
			Cadastrar
		</button>
		<button type="reset">
			Limpar
		</button>
	</div>
</form>