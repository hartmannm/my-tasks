package br.com.myTasks.models.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.myTasks.exceptions.NoTasksException;
import br.com.myTasks.interfaces.IHomeService;
import br.com.myTasks.interfaces.ITaskRepository;
import br.com.myTasks.models.entityes.Task;
import br.com.myTasks.models.entityes.User;

@RequestScoped
public class HomeService implements IHomeService {

	private ITaskRepository taskRepository;
	
	private List<Task> notFinishedTasks;
	private List<Task> finishedTasks;
	private Map<String, List<Task>> map;
	
	@Deprecated
	public HomeService() {
		this(null);
	}
	
	@Inject
	public HomeService(ITaskRepository taskRepository) {
		this.taskRepository = taskRepository;
		notFinishedTasks = new ArrayList<>();
		finishedTasks = new ArrayList<>();
	}
	
	@Override
	public Map<String, List<Task>> getTaskList(User user) throws NoTasksException {
		List<Task> list = taskRepository.getAll(user);
		if(list.isEmpty()) {
			throw new NoTasksException("Nenhuma tarefa cadastrada");
		}
		
		fillLists(list);
		
		map = new HashMap<>();
		fillMap(map);
		return map;
	}

	// métodos para criar e preencher lists e maps

	private void fillLists(List<Task> list) {
		for (Task task : list) {
			if (task.isFinished()) {
				finishedTasks.add(task);
			} else {
				notFinishedTasks.add(task);
			}
		}
	}

	private void fillMap(Map<String, List<Task>> map) {
		map.put("notFinishedTasks", notFinishedTasks);
		map.put("finishedTasks", finishedTasks);
	}

}
