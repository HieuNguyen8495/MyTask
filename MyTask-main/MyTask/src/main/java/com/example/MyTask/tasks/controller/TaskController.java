package com.example.MyTask.tasks.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyTask.tasks.dto.CreateTaskDto;
import com.example.MyTask.tasks.dto.TaskDto;
import com.example.MyTask.tasks.dto.UpdateTaskDto;
import com.example.MyTask.tasks.entity.TaskEntity;
import com.example.MyTask.tasks.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	private TaskService service;
	
	public TaskController(TaskService taskService) {
		service = taskService;
	}
	
	@GetMapping
	public List<TaskDto> findAllTasks(){
		List<TaskDto> listDto = service.findAllTasks();
		return listDto;
	}
	
	@PostMapping
	public TaskDto addNewTask(@Valid @RequestBody CreateTaskDto dto) {
		TaskDto taskDto = service.addTask(dto);
		return taskDto;
	}
	
	@PutMapping
	public TaskDto updateTask(@Valid @RequestBody UpdateTaskDto dto) {
		TaskDto updateTaskDto = service.updateTask(dto);
		return updateTaskDto;
	}
	
	@DeleteMapping("/{task-id}")
	public void deleteTask(@PathVariable("task-id") int taskId) {
		service.removeTask(taskId);
	}
}
