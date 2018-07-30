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

}
