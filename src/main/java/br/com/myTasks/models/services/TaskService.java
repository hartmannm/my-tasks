package br.com.myTasks.models.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.myTasks.exceptions.NoTasksException;
import br.com.myTasks.interfaces.ISession;
import br.com.myTasks.interfaces.ITaskRepository;
import br.com.myTasks.interfaces.ITaskService;
import br.com.myTasks.models.entityes.Task;
import br.com.myTasks.models.entityes.User;

@RequestScoped
public class TaskService implements ITaskService {
	
	private ISession session;
	private ITaskRepository taskRepository;
	
	private List<Task> pastTasks;
	private List<Task> presentTasks;
	private List<Task> futureTasks;
	
	@Deprecated
	public TaskService() {
		this(null, null);
	}
	
	@Inject
	public TaskService(ISession session, ITaskRepository taskRepository) {
		this.session = session;
		this.taskRepository = taskRepository;
	}

	@Override
	public void createTask(Task task) {
		task.setFinished(false);
		task.setUser(session.getUser());
		
		taskRepository.insert(task);
	}

	@Override
	public Map<String, List<Task>> getTaskList(User user) throws NoTasksException {
		List<Task> list = taskRepository.getAll(user);
		if(list.isEmpty()) {
			throw new NoTasksException("Nenhuma tarefa cadastrada");
		}
		
		createLists();
		fillLists(list);
		
		Map<String, List<Task>> map = new HashMap<>();
		fillMap(map);
		return map;
	}
	
	@Override
	public void remove(Long id) {
		Task task = taskRepository.get(id);
		taskRepository.remove(task);
	}

	//métodos para criar e preencher lists e maps
	private void createLists() {
		pastTasks = new ArrayList<>();
		presentTasks = new ArrayList<>();
		futureTasks = new ArrayList<>();
	}
	
	private void fillLists(List<Task> list) {
		for (Task task : list) {
			if(task.getDate().isBefore(LocalDate.now())) {
				pastTasks.add(task);
			} else if(task.getDate().isAfter(LocalDate.now())) {
				futureTasks.add(task);
			} else {
				presentTasks.add(task);
			}
		}
	}
	
	private void fillMap(Map<String, List<Task>> map) {
		map.put("pastTasks", pastTasks);
		map.put("presentTasks", presentTasks);
		map.put("futureTasks", futureTasks);
	}

}