package br.com.myTasks.controllers;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.myTasks.annotations.DataBaseAccess;
import br.com.myTasks.annotations.NeedToBeLogged;
import br.com.myTasks.exceptions.NoTasksException;
import br.com.myTasks.interfaces.IHomeService;
import br.com.myTasks.interfaces.ISession;
import br.com.myTasks.models.entityes.Task;

@RequestScoped
@Controller
@NeedToBeLogged
public class HomeController {

	private Result result;
	private IHomeService homeService;
	private ISession session;

	@Deprecated
	public HomeController() {
		this(null, null, null);
	}

	@Inject
	public HomeController(Result result, IHomeService homeService, ISession session) {
		this.result = result;
		this.homeService = homeService;
		this.session = session;
	}

	@DataBaseAccess
	@Path("/")
	public void home() {
		result.include("title", "Ínicio");
		try {
			Map<String, List<Task>> map = homeService.getTaskList(session.getUser());
			result.include("notFinishedTasks", map.get("notFinishedTasks"));
			result.include("finishedTasks", map.get("finishedTasks"));
			result.include("specificCSS", "main");
		} catch(NoTasksException e) {
			result.include("alertMessage", e.getMessage());
		}
	}

}
