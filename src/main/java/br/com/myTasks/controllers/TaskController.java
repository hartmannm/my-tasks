package br.com.myTasks.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@RequestScoped
@Controller
@Path("/tarefa")
public class TaskController {

	private Result result;
	
	@Deprecated
	public TaskController() {
		this(null);
	}
	
	@Inject
	public TaskController(Result result) {
		this.result = result;
	}
	
}