package br.com.myTasks.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.myTasks.annotations.DataBaseAccess;
import br.com.myTasks.exceptions.EncryptionException;
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
	public void register() {
		result.include("title", "Cadastro de usuário");
	}
	
	@DataBaseAccess
	@Post("/cadastro") 
	public void register(User user) {
		userValidator.validate(user);
		userValidator.onErrorRedirectTo(this).register();
		try {
			//salva a senha digitada para ser usada no login
			String password = user.getPassword();
			//cria o usuario
			userService.createUser(user);
			//recupera a senha digitada e utiliza o método de login
			user.setPassword(password);
			result.forwardTo(LoginController.class).login(user);
		} catch (UserExistenceExcepion e) {
			result.include("errorMessage", e.getMessage());
			result.redirectTo(this).register();
		} catch (EncryptionException e) {
			result.include("errorMessage", e.getMessage());
			result.use(Results.status()).internalServerError();
		}
	}
	
}