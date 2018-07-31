<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form method="POST" action="${linkTo[LoginController].login}">
	<div>
		<label for="user.email">Email</label>
		<input type="email" name="user.email" value="${user.email}"> 
		<span>${errors.from('user.email')}</span>
	</div>
	<div>
		<label for="user.password">Senha</label>
		<input type="password" name="user.password"> 
		<span>${errors.from('user.password')}</span>
	</div>
	<div>
		<button type="submit">
			Entrar
		</button>
	</div>
</form>