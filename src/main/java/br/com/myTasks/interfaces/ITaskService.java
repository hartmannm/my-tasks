package br.com.myTasks.interfaces;

import br.com.myTasks.models.entityes.Task;

public interface ITaskService {

	void createTask(Task task);
	
	void remove(Long id);

	void finish(Long id);

	Task get(Long id);

	void editTask(Task task);
	
}