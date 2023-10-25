package com.spring.boot.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.entities.User;
import com.spring.boot.repositories.UserRepository;





@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userRepo;
	

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}


	@Override
	public User updateUser(User user) {
		User fetchedUser = userRepo.findById(user.getId()).orElse(null);
		fetchedUser.setUsername(user.getUsername());
		fetchedUser.setFirstname(user.getFirstname());
		fetchedUser.setLastname(user.getLastname());
		fetchedUser.setEmail(user.getEmail());
		fetchedUser.setAge(user.getAge());
		fetchedUser.setPhonenumber(user.getPhonenumber());
		return userRepo.save(fetchedUser);
	}


	@Override
	public String deleteUser(Long userId) {
		if(userRepo.findById(userId).isPresent()) {
			userRepo.deleteById(userId);
			return "User deleted";
		}else {
			return "No user found";
		}
		
	}


	@Override
	public List<User> getUsers() {
		return (List<User>) userRepo.findAll();
	}


	@Override
	public User getUserById(Long userId) {
		User fetchedUser = userRepo.findById(userId).orElse(null);
		return fetchedUser;
	}



}
