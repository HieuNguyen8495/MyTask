package com.example.MyTask.security.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.MyTask.user.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private UserRepository repository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		repository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<User> user = repository.findByUsernameWithGroups(username);
//		
//		if(!user.isPresent())
//			throw new UsernameNotFoundException("Username is not existed.");
//		
//		Set<GrantedAuthority> authorities = getAuthorities(user.get().getGroups());
//		
//		return new UserDetailsDto(username, user.get().getPassword(), authorities);
		return null;
	}

//	private Set<GrantedAuthority> getAuthorities(Set<Group> groups) {
//		Set<GrantedAuthority> authorities = new HashSet<>();
//		
//		for(Group group : groups) {
//			authorities.add(new SimpleGrantedAuthority(group.getName()));
//		}
//		
//		return authorities;
//	}

}
