package com.example.MyTask.security.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.MyTask.security.dto.UserDetailsDto;
import com.example.MyTask.tasks.entity.TaskEntity;
import com.example.MyTask.user.entity.UserEntity;
import com.example.MyTask.user.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private UserRepository repository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		repository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = repository.findByName(username);
		
		if(!user.isPresent())
			throw new UsernameNotFoundException("Username is not existed.");
		
		Set<GrantedAuthority> authorities = getAuthorities(user.get().getTasks());
		
		return new UserDetailsDto(username, user.get().getPassword(), authorities);
		
	}

	private Set<GrantedAuthority> getAuthorities(Set<TaskEntity> tasks) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		for (TaskEntity t : tasks) {
			authorities.add(new SimpleGrantedAuthority(t.getTilte()));
		}
		
		return authorities;
	}

}
