package com.example.MyTask.tasks.service;

import java.util.List;

import javax.validation.Valid;

import com.example.MyTask.tasks.dto.CreateTaskDto;
import com.example.MyTask.tasks.dto.TaskDto;
import com.example.MyTask.tasks.dto.UpdateTaskDto;
import com.example.MyTask.tasks.entity.TaskEntity;

public interface TaskService {

	List<TaskDto> findAllTasks();

	TaskDto addTask(CreateTaskDto dto);

	TaskDto updateTask(UpdateTaskDto dto);

	void removeTask(int taskId);

}
