package com.example.MyTask.user.service;

import java.util.List;

import javax.validation.Valid;

import com.example.MyTask.tasks.dto.TaskDto;
import com.example.MyTask.user.dto.AddTaskDto;
import com.example.MyTask.user.dto.CreateUserDto;
import com.example.MyTask.user.dto.UpdateUserDto;
import com.example.MyTask.user.dto.UserDto;
import com.example.MyTask.user.entity.UserEntity;



public interface UserService {

	List<UserDto> findUser();

	UserDto addNewUser(CreateUserDto dto);

	UserDto updateUser(UpdateUserDto dto);

	void removeUser(int userId);

	boolean isTakenName(String name);

	boolean isTakenEmail(String email);

	boolean isExistNameId(Integer nameId);

	boolean isExistTaskId(Integer taskId);

	TaskDto addTask(int userId, AddTaskDto dto);

}
