package com.todo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.Task;
import com.todo.service.TaskService;

@RestController
@RequestMapping("/api")
public class MainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private TaskService taskService;

	@RequestMapping("allTasks")
	public List<Task> getAllTasks() {
		LOGGER.info("MainController - {}", "getAllTasks");
		return taskService.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{taskId}")
	public void deleteTask(@PathVariable("taskId") String id) {
		LOGGER.info("MainController - {}", "deleteTask");
		taskService.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public Task addTask(@RequestBody Task task) {
		LOGGER.info("MainController - {}", "addTask");
		return this.taskService.save(task);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/update")
	public int updateTask(@RequestBody Task task) {
		LOGGER.info("MainController - {}", "updateTask");
		return this.taskService.update(task);
	}

}
