<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <c:import url="../commons/head.jsp" />
	
	<div class="row">
    	<div class="col s12">
    	
	    	<main>
	    		<div class="card-panel">
       				<c:if test="${not empty errorMessage}">
						<c:import url="../commons/msgErrorAlert.jsp" />
					</c:if>
				    
				    <form method="POST" action="${linkTo[UserController].register}">
						<!--nome de usuário-->
						<div class="input-field col s12">
							<label for="user.name">Nome de usuário</label>
							<input type="text" name="user.name" value="${user.name}">
							<span>${errors.from('user.name')}</span>
						</div>
						<!--email-->
						<div class="input-field col s12">
							<label for="user.email">Email</label>
							<input type="email" name="user.email" value="${user.email}"> 
							<span>${errors.from('user.email')}</span>
						</div>
						<!--senha-->
						<div class="row">
							<div class="input-field col s12 m6">
								<label for="user.password">Senha</label>
								<input type="password" name="user.password" />
								<span>${errors.from('user.password')}</span>
							</div>
							<!--repetição de senha-->
							<div class="input-field col s12 m6">
								<label for="user.passwordConfirm">Repita a senha</label>
								<input type="password" name="user.passwordConfirm" />
								<span>${errors.from('user.passwordConfirm')}</span>
							</div>
						</div>
					
						<div>
							<button type="submit" class="btn">
								Cadastrar
							</button>
							<button type="reset"  class="btn red darken-4">
								Limpar
							</button>
						</div>
					</form>
     			</div>
	    	</main>
	    	
    	</div>
    </div>

    <c:import url="../commons/endBody.jsp" />