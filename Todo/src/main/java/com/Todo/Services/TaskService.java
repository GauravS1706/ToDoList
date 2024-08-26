package com.Todo.Services;

import java.util.List;

import com.Todo.Entity.Tasks;

public interface TaskService {
	
	public Tasks createNewTask(Tasks task);
	
	public List<Tasks> getAllTask();
	
	public Tasks findTask(String task);
	public Tasks findTaskById(int id);
	
	public List<Tasks> findAllCompletedTask();
	
	public List<Tasks> findAllInCompletedTask();
	
	
	public boolean deleteTask(int id);
	
	public Tasks updateTask(Tasks task);
	
}
