<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <c:import url="../commons/head.jsp" />
    
    <c:import url="form.jsp" />
    
    <div>
		Ainda não tem uma conta? 
		<a href="${linkTo[UserController].register}">
			<span class="strong">Criar conta</span>
		</a>
	</div>
    
    <c:import url="../commons/endBody.jsp" />