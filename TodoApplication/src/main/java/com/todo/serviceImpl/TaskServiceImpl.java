package com.todo.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.model.Task;
import com.todo.repository.TaskRepository;
import com.todo.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task save(Task task) {
		LOGGER.info("TaskServiceImpl - {}", "save");
		return taskRepository.save(task);
	}

	@Override
	public List<Task> findAll() {
		LOGGER.info("TaskServiceImpl - {}", "findAll");
		return taskRepository.findAll();
	}

	@Override
	public void delete(String taskId) {
		LOGGER.info("TaskServiceImpl - {}", "delete");
		taskRepository.delete(taskId);
	}

	@Override
	public int update(Task task) {
		LOGGER.info("TaskServiceImpl - {}", "update");
		return taskRepository.update(task);
	}

}
