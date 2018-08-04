package br.com.myTasks.models.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.myTasks.interfaces.ISession;
import br.com.myTasks.interfaces.ITaskRepository;
import br.com.myTasks.interfaces.ITaskService;
import br.com.myTasks.models.entityes.Task;

@RequestScoped
public class TaskService implements ITaskService {
	
	private ISession session;
	private ITaskRepository taskRepository;
	private Task task;

	@Deprecated
	public TaskService() {
		this(null, null, null);
	}
	
	@Inject
	public TaskService(ISession session, ITaskRepository taskRepository, Task task) {
		this.session = session;
		this.taskRepository = taskRepository;
		this.task = task;
	}

	@Override
	public void createTask(Task task) {
		task.setFinished(false);
		task.setUser(session.getUser());
		
		taskRepository.insert(task);
	}
	
	@Override
	public void remove(Long id) {
		task = taskRepository.get(id);
		taskRepository.remove(task);
	}

	@Override
	public void finish(Long id) {
		task = taskRepository.get(id);
		task.setFinished(true);
		taskRepository.finish(task);
	}
	
	@Override
	public Task get(Long id) {
		return taskRepository.get(id);
	}
	
	@Override
	public void editTask(Task task) {
		Task dbTask = taskRepository.get(task.getId());
		dbTask.setName(task.getName());
		dbTask.setDate(task.getDate());
		dbTask.setHour(task.getHour());
		dbTask.setFinished(task.isFinished());
		dbTask.setDetails(task.getDetails());
		taskRepository.edit(dbTask);
	}

}