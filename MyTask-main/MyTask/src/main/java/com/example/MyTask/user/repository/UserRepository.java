package com.example.MyTask.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MyTask.user.dto.UserDto;
import com.example.MyTask.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	@Query("SELECT u FROM UserEntity u")
	List<UserDto> findUserDto();

	int countByName(String name);

	int countByEmail(String email);
	
	Optional<UserEntity> findByName(String name);
	
	
}
