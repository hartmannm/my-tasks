<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <c:import url="../commons/head.jsp" />
    
    <div class="container">
	    <div class="row">
	    	<div class="col s12 m8 l8 offset-m2 offset-l2">
		    	<main>
		    		<div class="card-panel">
		    			<h1 class="center-align">Login</h1>
	       				<c:if test="${not empty errorMessage}">
							<c:import url="../commons/msgErrorAlert.jsp" />
						</c:if>
					    <form method="POST" action="${linkTo[LoginController].login}">
							<div class="input-field">
								<input type="email" name="user.email" value="${user.email}" class="validate">
								<label for="user.email" class="active">Email</label>
								<span class="error">${errors.from('user.email')}</span>
						    </div>
						    <div class="input-field">
								<input type="password" name="user.password" class="validate">
								<label for="user.password" class="active">Senha</label>
								<span class="error">${errors.from('user.password')}</span>
						    </div>
							<div>
								<button class="btn waves-effect waves-light" type="submit">
									Entrar
							    	<i class="material-icons right">send</i>
							    </button>
							</div>
						</form>
					    
					    <div class="center-align link">
							Ainda não tem uma conta? 
							<a href="${linkTo[UserController].register}">
								<span class="strong">Criar conta</span>
							</a>
						</div>
	     			</div>
		    	</main>	    	
	    	</div>
	    </div>
    
    <c:import url="../commons/endBody.jsp" />