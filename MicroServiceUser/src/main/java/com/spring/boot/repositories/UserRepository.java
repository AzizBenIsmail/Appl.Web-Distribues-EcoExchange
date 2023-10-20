package com.spring.boot.repositories;

import org.springframework.data.repository.CrudRepository;



import com.spring.boot.entities.User;

public interface UserRepository extends CrudRepository <User, Long> {

	
}
