package br.com.myTasks.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.myTasks.interfaces.ILoginValidator;
import br.com.myTasks.models.entityes.User;

@Controller
@RequestScoped
public class LoginController {

	private Result result;
	private ILoginValidator loginValidator;
	
	@Deprecated
	public LoginController( ) {
		this(null, null);
	}
	
	@Inject
	public LoginController(Result result, ILoginValidator loginValidator) {
		this.result = result;
		this.loginValidator = loginValidator;
	}
	
	@Get("/login")
	public void login() {
		result.include("title", "Login");
	}
	
	@Post("/login")
	public void login(User user) {
		loginValidator.validate(user);
		loginValidator.onErrorRedirectTo(this).login();
		
		
	}
	
}
