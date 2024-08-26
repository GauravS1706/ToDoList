package com.Todo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Todo.Entity.Tasks;
import com.Todo.Repository.TaskRepo;


@Service
public class TaskServImpl implements TaskService {

	@Autowired
	private	TaskRepo tr;
	@Override
	public Tasks createNewTask(Tasks task) {
		// TODO Auto-generated method stub
		return tr.save(task);
	}

	@Override
	public List<Tasks> getAllTask() {
		// TODO Auto-generated method stub
		return tr.findAll();
	}

	@Override
	public Tasks findTaskById(int id) {
		// TODO Auto-generated method stub
		return tr.findById(id).get();
	}

	@Override
	public List<Tasks> findAllCompletedTask() {
		// TODO Auto-generated method stub
		return tr.findByCompletedTrue();
	}

	@Override
	public List<Tasks> findAllInCompletedTask() {
		// TODO Auto-generated method stub
		return tr.findByCompletedFalse();
	}

	@Override
	public boolean  deleteTask(int id) {
		// TODO Auto-generated method stub
		tr.deleteById(id);
		return true;
		
	}

	@Override
	public Tasks updateTask(Tasks task) {
		// TODO Auto-generated method stub
		return tr.save(task);
		
	}

	@Override
	public Tasks findTask(String task) {
		// TODO Auto-generated method stub
		return tr.findByTask(task);
	}
	
}
