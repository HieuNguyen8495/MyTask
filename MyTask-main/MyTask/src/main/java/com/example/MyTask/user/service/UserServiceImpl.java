package com.example.MyTask.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.MyTask.tasks.dto.TaskDto;
import com.example.MyTask.tasks.entity.TaskEntity;
import com.example.MyTask.tasks.repository.TaskRepository;
import com.example.MyTask.user.dto.AddTaskDto;
import com.example.MyTask.user.dto.CreateUserDto;
import com.example.MyTask.user.dto.UpdateUserDto;
import com.example.MyTask.user.dto.UserDto;
import com.example.MyTask.user.entity.UserEntity;
import com.example.MyTask.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepo;
	private TaskRepository taskRepo;
	private PasswordEncoder encoder;
	
	public UserServiceImpl(UserRepository repository, TaskRepository repo, PasswordEncoder pwEncoder) {
		userRepo = repository;
		taskRepo = repo;
		encoder = pwEncoder;
	}
	
	@Override
	public List<UserDto> findUser() {
		List<UserDto> listDto = new ArrayList<>();
		List<UserEntity> listUser = userRepo.findAll();
		
		for (UserEntity u : listUser) {
			UserDto dto = new UserDto();
			dto.setId(u.getId());
			dto.setName(u.getName());
			dto.setDisplayName(u.getDisplayName());
			dto.setPassword(u.getPassword());
			dto.setEmail(u.getEmail());
			
			listDto.add(dto);
		}
		
		List<UserDto> dto1 = listUser.stream().map(u -> {
			UserDto dto = new UserDto();
			dto.setId(u.getId());
			dto.setName(u.getName());
			dto.setDisplayName(u.getDisplayName());
			dto.setPassword(u.getPassword());
			dto.setEmail(u.getEmail());
			return dto;
		}).toList();
		
		return  listDto;
	}
	
	
	@Override
	public UserDto addNewUser(CreateUserDto dto) {
		UserEntity userEntity = new UserEntity();
			userEntity.setName(dto.getName());
			userEntity.setDisplayName(dto.getDisplayName());
			userEntity.setPassword(encoder.encode(dto.getPassword()));
			userEntity.setEmail(dto.getEmail());
		
		UserEntity newUser = userRepo.save(userEntity);
		
		UserDto newUserDto = new UserDto();
			newUserDto.setName(newUser.getName());
			newUserDto.setDisplayName(newUser.getDisplayName());
			newUserDto.setPassword(newUser.getPassword());
			newUserDto.setEmail(newUser.getEmail());
		
		return newUserDto;
	}
	@Override
	public UserDto updateUser(UpdateUserDto dto) {
		UserEntity updateUser = userRepo.getById(dto.getId());
		
		updateUser.setName(dto.getName());
		updateUser.setDisplayName(dto.getDisplayName());
		updateUser.setPassword(dto.getPassword());
		updateUser.setEmail(dto.getEmail());
		
		UserEntity savedUser = userRepo.save(updateUser);
		
		UserDto userUpdateDto = new UserDto();
		userUpdateDto.setName(updateUser.getName());
		userUpdateDto.setDisplayName(updateUser.getDisplayName());
		userUpdateDto.setPassword(updateUser.getPassword());
		userUpdateDto.setEmail(updateUser.getEmail());
		
		return userUpdateDto;
	}
	@Override
	public void removeUser(int userId) {
		userRepo.deleteById(userId);
		
	}

	@Override
	public boolean isTakenName(String name) {
		return userRepo.countByName(name) >= 1;
	}

	@Override
	public boolean isTakenEmail(String email) {
		return userRepo.countByEmail(email) >= 1;
	}

	@Override
	public boolean isExistNameId(Integer nameId) {
		return userRepo.existsById(nameId);
	}

	@Override
	public boolean isExistTaskId(Integer taskId) {
		return userRepo.existsById(taskId);
	}
	
	@Transactional
	@Override
	public TaskDto addTask(int userId, AddTaskDto dto) {
//		UserEntity user = userRepo.getById(userId);
//		UserEntity targetUser = userRepo.getById(dto.getTaskId());
//		TaskEntity targetTask = taskRepo.getById(dto.getTaskId());
//		
//		user.addTask(targetTask, userId );
//		
//		TaskDto taskDto = new TaskDto();
//		taskDto.setTilte(task.getTilte());
//		taskDto.setDescription(task.getDescription());
//		taskDto.setScore(task.getScore());
//		taskDto.setStatus(task.getStatus());
//		
//		user.addTask(taskDto);
		
		return null;
		  
		
	}
	
	
	
	

}
