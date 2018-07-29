package br.com.myTasks.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@RequestScoped
@Controller
public class HomeController {

	private Result result;
	
	@Deprecated
	public HomeController() {
		this(null);
	}
	
	@Inject
	public HomeController(Result result) {
		this.result = result;
	}
	
	@Path("/")
	public void home() {
		result.include("title", "Ínicio");
	}
	
}
