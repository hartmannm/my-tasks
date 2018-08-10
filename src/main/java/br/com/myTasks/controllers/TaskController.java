package br.com.myTasks.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.myTasks.annotations.DataBaseAccess;
import br.com.myTasks.annotations.NeedToBeLogged;
import br.com.myTasks.interfaces.ITaskService;
import br.com.myTasks.interfaces.ITaskValidator;
import br.com.myTasks.models.entityes.Task;

@Controller
@Path("/tarefa")
@NeedToBeLogged
public class TaskController {

	private Result result;
	private ITaskValidator validator;
	private ITaskService taskService;
	private Task task;
	
	@Deprecated
	public TaskController() {
		this(null, null, null, null);
	}
	
	@Inject
	public TaskController(Result result, ITaskValidator validator, 
							ITaskService taskService, Task task) {
		this.result = result;
		this.validator = validator;
		this.taskService = taskService;
		this.task = task;
	}
	
	@Get("/cadastro")
	public void register() {
		result.include("title", "Cadastro de tarefa");
		result.include("specificCSS", "main");
	}
	
	@DataBaseAccess
	@Post("/cadastro")
	public void register(Task task) {
		validator.validate(task);
		validator.onErrorRedirectTo(this).register();

		if(task.getId() == null) {
			taskService.createTask(task);
			result.include("successMessage", "Tarefa cadastrada com sucesso!");
		} else {
			taskService.editTask(task);
			result.include("successMessage", "Tarefa editada com sucesso!");
		}
		
		result.redirectTo(HomeController.class).home();
	}
	
	@DataBaseAccess
	@Get("/excluir/{id}")
	public void remove(Long id) {
		taskService.remove(id);
		result.include("successMessage", "Tarefa excluída com sucesso!");
		result.redirectTo(HomeController.class).home();
	}
	
	@DataBaseAccess
	@Get("/finalizar/{id}")
	public void finish(Long id) {
		taskService.finish(id);
		result.include("successMessage", "Tarefa finalizada!");
		result.redirectTo(HomeController.class).home();
	}
	
	@DataBaseAccess
	@Get("editar/{id}")
	public void edit(Long id) {
		task = taskService.get(id);
		result.include(task);
		result.include("title", "Editar - " + task.getName());
		result.include("specificCSS", "main");
	}
	
}