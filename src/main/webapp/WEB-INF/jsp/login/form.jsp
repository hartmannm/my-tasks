<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form method="POST" action="${linkTo[LoginController].login}">
	<div class="input-field col s12">
		<input type="email" name="user.email" value="${user.email}" class="validate">
		<label for="user.email" class="active">Email</label>
		<span>${errors.from('user.email')}</span>
    </div>
    <div class="input-field col s12">
		<input type="password" name="user.password" class="validate">
		<label for="user.password" class="active">Senha</label>
		<span>${errors.from('user.password')}</span>
    </div>
	<div>
		<button class="btn waves-effect waves-light" type="submit">
			Entrar
	    	<i class="material-icons right">send</i>
	    </button>
	</div>
</form>