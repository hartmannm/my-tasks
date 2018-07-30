package br.com.myTasks.models.repositories;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.myTasks.interfaces.ITaskRepository;
import br.com.myTasks.models.entityes.Task;

@RequestScoped
public class TaskRepository implements ITaskRepository {

	private EntityManager manager;
	
	@Deprecated
	public TaskRepository() {
		this(null);
	}

	@Inject
	public TaskRepository(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void insert(Task task) {
		manager.persist(task);
	}

}
