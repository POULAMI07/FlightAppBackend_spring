package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.userModel;
import com.example.repository.userRepository;
@Service
public class userService {
	@Autowired
	private userRepository repository;

	public userModel addUser(userModel user) {
		return repository.save(user);
	}
	
	public userModel checkUser(String email,String pass) {
		return repository.findByUserPass(email,pass);
	}
	
	public userModel findUserById(int id) {
		System.out.println("in user service id: " + id);
		Optional<userModel> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public userModel findUserByEmail(String name) {
		System.out.println("in user service email: " + name);
		return repository.findByUserEmail(name);
	}

}
