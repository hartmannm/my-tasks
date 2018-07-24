package br.com.myTasks.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.myTasks.models.entityes.User;

@Controller
@RequestScoped
public class LoginController {

	private Result result;
	
	@Deprecated
	public LoginController( ) {
		this(null);
	}
	
	@Inject
	public LoginController(Result result) {
		this.result = result;
	}
	
	@Get("/login")
	public void login() {
		result.include("title", "Login");
	}
	
	@Post("/login")
	public void login(User user) {
		
	}
	
}
