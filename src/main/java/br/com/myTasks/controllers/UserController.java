package br.com.myTasks.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.myTasks.annotations.DataBaseAccess;
import br.com.myTasks.exceptions.UserExistenceExcepion;
import br.com.myTasks.interfaces.IUserService;
import br.com.myTasks.interfaces.IUserValidator;
import br.com.myTasks.models.entityes.User;

@Controller
@Path("/usuario")
public class UserController {
	
	private IUserService userService;
	private Result result;
	private IUserValidator userValidator;
	
	@Deprecated
	public UserController() {
		this(null, null, null);
	}

	@Inject
	public UserController(IUserService userService, Result result, IUserValidator userValidator) {
		this.userService = userService;
		this.result = result;
		this.userValidator = userValidator;
	}
	
	@Get("/cadastro")
	public void cadastro() {
		result.include("title", "Cadastro de usuário");
	}
	
	@DataBaseAccess
	@Post("/cadastro") 
	public void cadastro(User user) {
		userValidator.validate(user);
		userValidator.onErrorRedirectTo(this).cadastro();
		
		try {
			userService.createUser(user);
			result.redirectTo("https://www.facebook.com/");
		} catch (UserExistenceExcepion e) {
			result.include("errorMessage", e.getMessage());
			result.redirectTo(this).cadastro();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			result.include("errorMessage", "Erro interno do sistema, desculpe pelo transtorno!");
			result.use(Results.status()).internalServerError();
		}
	}
	
}