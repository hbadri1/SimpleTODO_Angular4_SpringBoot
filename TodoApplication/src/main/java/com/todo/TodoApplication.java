package com.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.todo.model.Task;
import com.todo.repository.TaskRepository;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	/**
	 * init here is for testing purposes only
	 * 
	 * @param taskRepo
	 * @return
	 */
	@Bean
	CommandLineRunner init(TaskRepository taskRepo) {
		return args -> {
			/*taskRepo.save(new Task("Todo 1"));
			taskRepo.save(new Task("Todo 2"));
			taskRepo.save(new Task("Todo 3"));*/
			//Let's try find all
			System.out.println(taskRepo.findAll());
		};
	}
}
