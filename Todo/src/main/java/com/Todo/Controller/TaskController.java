package com.Todo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.Todo.Entity.Tasks;
import com.Todo.Services.TaskServImpl;


@RestController
public class TaskController {
	
	@Autowired
	private TaskServImpl taskService;

	@PostMapping("/Task/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tasks createTask(@RequestBody Tasks task)
	{
		return taskService.createNewTask(task);
	}
	
	@GetMapping("/Task")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Tasks> getAllTask()
	{
		return taskService.getAllTask();
	}
	
	@GetMapping("/Task/Completed")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Tasks> getAllCompletedTask()
	{
		return taskService.findAllCompletedTask();
	}
	
	@GetMapping("/Task/InCompleted")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Tasks> getAllInCompletedTask()
	{
		return taskService.findAllInCompletedTask();
	}
	
	
	@GetMapping("/Task/Find/{String}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Tasks findByTaskName(@PathVariable("String") String task)
	{
		return taskService.findTask(task);
	}
	
	@GetMapping("/Task/find/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Tasks findTaskById(@PathVariable("id") int id)
	{
		return taskService.findTaskById(id);
	}
	
	@PutMapping("/Task/update/{id}")
	@ResponseBody
	public Tasks updateTask(@PathVariable("id") int id, @RequestBody Tasks task) {
	    Tasks existingTask = taskService.findTaskById(id);
	    if (existingTask != null) {
	        task.setId(id); // Ensure the task ID is set to the path variable ID
	        return taskService.updateTask(task);
	    } else {
	        // Handle the case where the task with the given ID does not exist
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
	    }
	}

	
	@DeleteMapping("/Task/Delete/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public boolean deleteTask(@PathVariable("id") int  id)
	{	Tasks task=taskService.findTaskById(id);
		if(task.getId() == id) {
		taskService.deleteTask(id);
		return true;
		}
		return false;
	}

	
}
