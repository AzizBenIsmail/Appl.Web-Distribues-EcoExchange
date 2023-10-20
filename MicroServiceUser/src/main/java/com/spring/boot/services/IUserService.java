package com.spring.boot.services;

import java.util.List;

import com.spring.boot.entities.User;




public interface IUserService {
	
	User addUser(User user);
	User updateUser(User user);
	String deleteUser(Long userId);
	User getUserById(Long userId);
	List<User> getUsers();
	

}
