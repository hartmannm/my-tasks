package br.com.myTasks.models.repositories;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.myTasks.interfaces.ITaskRepository;
import br.com.myTasks.models.entityes.Task;
import br.com.myTasks.models.entityes.User;

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

	@Override
	public List<Task> getAll(User user) {
		String queryString = "select t from Task t where t.user = :user";
		TypedQuery<Task> query = manager.createQuery(queryString, Task.class);
		query.setParameter("user", user);
		return query.getResultList();
	}

}
