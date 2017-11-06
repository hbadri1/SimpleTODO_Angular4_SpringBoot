package com.todo.service;

import java.util.List;
import com.todo.model.Task;

public interface TaskService {
	Task save(Task task);
	List<Task> findAll();
	void delete(String taskId);
	int update(Task task);
}
