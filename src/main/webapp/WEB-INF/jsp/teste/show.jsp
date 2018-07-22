<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkTo[TesteController].cadUsuario}">
		Nome: <input type="text" name="usuario.nome" />
		<br>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>