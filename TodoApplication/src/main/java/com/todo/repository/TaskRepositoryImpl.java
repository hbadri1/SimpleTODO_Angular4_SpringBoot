package com.todo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;
import com.todo.model.Task;

public class TaskRepositoryImpl implements CustomTaskRepository {

	
	@Autowired
	MongoTemplate mongoTemplate; 
	
	@Override
	public int update(Task task) {
		Query query = new Query(Criteria.where("_id").is(task.id));
		Update update = new Update();
		update.set("done", task.isDone());
		WriteResult res = mongoTemplate.updateFirst(query, update, Task.class);
		if(res != null) {
			return res.getN();
		}
		return 0;
	}

}
