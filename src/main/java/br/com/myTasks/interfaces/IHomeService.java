package br.com.myTasks.interfaces;

import java.util.List;
import java.util.Map;

import br.com.myTasks.exceptions.NoTasksException;
import br.com.myTasks.models.entityes.Task;
import br.com.myTasks.models.entityes.User;

public interface IHomeService {

	Map<String, List<Task>> getTaskList(User user) throws NoTasksException;

}
