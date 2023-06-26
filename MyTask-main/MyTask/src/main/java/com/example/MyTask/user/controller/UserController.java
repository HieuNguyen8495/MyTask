package com.example.MyTask.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyTask.tasks.dto.TaskDto;
import com.example.MyTask.user.dto.AddTaskDto;
import com.example.MyTask.user.dto.CreateUserDto;
import com.example.MyTask.user.dto.UpdateUserDto;
import com.example.MyTask.user.dto.UserDto;
import com.example.MyTask.user.entity.UserEntity;
import com.example.MyTask.user.service.UserService;
import com.example.MyTask.util.ResponseHandler;

@Validated
@RestController
@RequestMapping("/api/user")
public class UserController {
	private UserService service;
	
	public UserController(UserService userService) {
		service = userService;
	}
	
	@GetMapping
	public List<UserDto> findAllUsers() {
		List<UserDto> userDto = service.findUser();
			return userDto;
	}
	
	@PostMapping
	public UserDto addUser(@Valid @RequestBody CreateUserDto dto) {
		UserDto userDto = service.addNewUser(dto);
			return userDto;
	}
	
	@PutMapping
	public UserDto updateUser(@Valid @RequestBody UpdateUserDto dto) {
		UserDto  updatedUser = service.updateUser(dto);
		    return updatedUser;
	}
	
	@DeleteMapping("/{user-id}")
	public void deleteUser(@PathVariable("user-id") int userId) {
		service.removeUser(userId);
	}
	
	@PostMapping("/{user-id}/add-task")
	public TaskDto addTask(@PathVariable("usrer-id") int userId,@Valid @RequestBody AddTaskDto dto ) {
		TaskDto addTaskToUser = service.addTask(userId,dto);
		return addTaskToUser;
	}

}
