package com.spring.boot.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.entities.User;
import com.spring.boot.services.IUserService;

//import io.swagger.annotations.ApiOperation;



@Controller
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	IUserService userService;
	


	//@ApiOperation(value="Add new User")
	@PostMapping("/add")
	@ResponseBody
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	//@ApiOperation(value="Update User")
	@PostMapping("/update")
	@ResponseBody
	public User updateUser(@RequestBody User user) {
		return this.userService.updateUser(user);
	}

	//@ApiOperation(value="Delete User")
	@DeleteMapping("/{idUser}")
	@ResponseBody
	public String deleteUser(@PathVariable("idUser") Long idUser ) {
		return this.userService.deleteUser(idUser);
	}
	
	//@ApiOperation(value="Get User By ID")
	@GetMapping("/{idUser}")
	@ResponseBody
	public User getUserById(@PathVariable("idUser") Long idUser) {
		 return this.userService.getUserById(idUser);
	}

	//@ApiOperation(value="Get Users")
	@GetMapping("/users")
	@ResponseBody
	public List<User> getUsers() {
		 return this.userService.getUsers();
	}

	
}
