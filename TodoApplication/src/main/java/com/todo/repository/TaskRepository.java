package com.todo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.todo.model.Task;

public interface TaskRepository extends MongoRepository<Task, String>, CustomTaskRepository{
}
