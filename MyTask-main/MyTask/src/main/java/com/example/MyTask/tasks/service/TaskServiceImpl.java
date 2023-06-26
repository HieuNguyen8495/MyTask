package com.example.MyTask.tasks.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.MyTask.tasks.dto.CreateTaskDto;
import com.example.MyTask.tasks.dto.TaskDto;
import com.example.MyTask.tasks.dto.UpdateTaskDto;
import com.example.MyTask.tasks.entity.TaskEntity;
import com.example.MyTask.tasks.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
	private TaskRepository taskRepo;
	
	public TaskServiceImpl(TaskRepository repository) {
		taskRepo = repository;
	}

	@Override
	public List<TaskDto> findAllTasks() {
		List<TaskEntity> listTaskEntity = taskRepo.findAll();
		List<TaskDto> listTaskDto = new ArrayList<>();
		
		for (TaskEntity t : listTaskEntity) {
			TaskDto dto = new TaskDto();
			  dto.setId(t.getId());
			  dto.setTilte(t.getTilte());
			  dto.setDescription(t.getTilte());
			  dto.setStatus(t.getStatus());
			  dto.setScore(t.getScore());
			listTaskDto.add(dto);
		}
		
		List<TaskDto> dto1 = listTaskEntity.stream().map(t -> {
			TaskDto dto = new TaskDto();
			  dto.setId(t.getId());
			  dto.setTilte(t.getTilte());
			  dto.setDescription(t.getTilte());
			  dto.setStatus(t.getStatus());
			  dto.setScore(t.getScore());
			  return dto;
		}).toList();
		
		return listTaskDto;
	}

	@Override
	public TaskDto addTask(CreateTaskDto dto) {
		TaskEntity t = new TaskEntity();
		t.setTilte(dto.getTilte());
		t.setDescription(dto.getDescription());
		t.setScore(dto.getScore());
		t.setStatus(dto.getStatus());
		
		taskRepo.save(t);
		
		TaskDto taskDto = new TaskDto();
		taskDto.setTilte(t.getTilte());
		taskDto.setTilte(t.getTilte());
		taskDto.setDescription(t.getDescription());
		taskDto.setScore(t.getScore());
		taskDto.setStatus(t.getStatus());
		
		return taskDto;
	}

	@Override
	public TaskDto updateTask(UpdateTaskDto dto) {
		TaskEntity updatedTask = taskRepo.getById(dto.getId());
		
		updatedTask.setTilte(dto.getTilte());
		updatedTask.setDescription(dto.getDescription());
		updatedTask.setScore(dto.getScore());
		updatedTask.setStatus(dto.getStatus());
		
		TaskEntity t = taskRepo.save(updatedTask);
		
		TaskDto dto1 = new TaskDto();
		dto1.setTilte(t.getTilte());
		dto1.setDescription(t.getDescription());
		dto1.setScore(t.getScore());
		dto1.setStatus(t.getStatus());
		
		return dto1;
	}

	@Override
	public void removeTask(int taskId) {
		taskRepo.deleteById(taskId);
	}
	
	

}
