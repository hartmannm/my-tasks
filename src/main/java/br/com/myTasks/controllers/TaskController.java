package br.com.myTasks.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.myTasks.annotations.DataBaseAccess;
import br.com.myTasks.interfaces.ITaskService;
import br.com.myTasks.interfaces.ITaskValidator;
import br.com.myTasks.models.entityes.Task;

@Controller
@Path("/tarefa")
public class TaskController {

	private Result result;
	private ITaskValidator validator;
	private ITaskService taskService;
	
	@Deprecated
	public TaskController() {
		this(null, null, null);
	}
	
	@Inject
	public TaskController(Result result, ITaskValidator validator, ITaskService taskService) {
		this.result = result;
		this.validator = validator;
		this.taskService = taskService;
	}
	
	@Get("/cadastro")
	public void register() {
		result.include("title", "Cadastro de tarefa");
	}
	
	@DataBaseAccess
	@Post("/cadastro")
	public void register(Task task) {
		validator.validate(task);
		validator.onErrorRedirectTo(this).register();

		taskService.createTask(task);
		result.include("successMessage", "Tarefa cadastrada com sucesso!");
		result.forwardTo(HomeController.class).home();
	}
	
}