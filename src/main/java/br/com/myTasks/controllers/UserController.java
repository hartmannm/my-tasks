package br.com.myTasks.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.myTasks.interfaces.IUserService;
import br.com.myTasks.interfaces.IUserValidator;
import br.com.myTasks.models.entityes.User;

@Controller
@Path("/usuario")
public class UserController {
	
	private IUserService service;
	private Result result;
	private IUserValidator userValidator;
	
	@Deprecated
	public UserController() {
		this(null, null, null);
	}

	@Inject
	public UserController(IUserService service, Result result, IUserValidator userValidator) {
		this.service = service;
		this.result = result;
		this.userValidator = userValidator;
	}
	
	@Get("/cadastro")
	public void cadastro() {
		result.include("title", "Cadastro de usuário");
	}
	
	@Post("/cadastro") 
	public void cadastro(User user) {
		userValidator.validate(user);
		userValidator.onErrorRedirectTo(this).cadastro();
	}
	
}
