package com.Todo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Todo.Entity.Tasks;


//@Repository
public interface TaskRepo extends JpaRepository<Tasks, Integer> {

	public Tasks findByTask(String task);
	
	public List<Tasks> findByCompletedTrue();
	
	public List<Tasks> findByCompletedFalse();
	
}
