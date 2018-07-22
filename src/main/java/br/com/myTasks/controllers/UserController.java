package br.com.myTasks.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.myTasks.interfaces.IUserService;
import br.com.myTasks.models.entityes.User;

@Controller
@Path("/usuario")
public class UserController {
	
	private IUserService service;
	
	@Deprecated
	public UserController() {
		this(null);
	}

	@Inject
	public UserController(IUserService service) {
		this.service = service;
	}
	
	@Path("/inserir")
	public void inserir() {
		User user = new User();
		user.setEmail("email");
		user.setSenha("senha");
		user.setNome("nome");
		
		service.createUser(user);
		System.out.println("controller");
	}
	
}
