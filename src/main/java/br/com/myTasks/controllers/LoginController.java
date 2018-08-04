package br.com.myTasks.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.myTasks.annotations.DataBaseAccess;
import br.com.myTasks.exceptions.UserExistenceExcepion;
import br.com.myTasks.interfaces.ILoginService;
import br.com.myTasks.interfaces.ILoginValidator;
import br.com.myTasks.interfaces.ISession;
import br.com.myTasks.models.entityes.User;

@Controller
@RequestScoped
public class LoginController {

	private Result result;
	private ILoginValidator loginValidator;
	private ILoginService loginService;
	private ISession session;
	
	@Deprecated
	public LoginController( ) {
		this(null, null, null, null);
	}
	
	@Inject
	public LoginController(Result result, ILoginValidator loginValidator, 
							ILoginService loginService, ISession session) {
		this.result = result;
		this.loginValidator = loginValidator;
		this.loginService = loginService;
		this.session = session;
	}
	
	@Get("/login")
	public void login() {
		result.include("title", "Login");
	}
	
	@DataBaseAccess
	@Post("/login")
	public void login(User user) {
		loginValidator.validate(user);
		loginValidator.onErrorRedirectTo(this).login();
		
		try {
			session.login(loginService.login(user));
			result.redirectTo(HomeController.class).home();
		} catch (UserExistenceExcepion e) {
			result.include("errorMessage", e.getMessage());
			result.redirectTo(this).login();
		}
	}
	
	@Get("/logout")
	public void logout() {
		loginService.logout();
		result.redirectTo(this).login();
	}
	
}
