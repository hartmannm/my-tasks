package br.com.myTasks.interfaces;

import java.util.List;

import br.com.myTasks.models.entityes.Task;
import br.com.myTasks.models.entityes.User;

public interface ITaskRepository {

	void insert(Task task);
	
	Task get(Long id);
	
	List<Task> getAll(User user);
	
	void remove(Task task);

}
