package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.userModel;


public interface userRepository extends JpaRepository<userModel, Integer>{
	
	@Query("SELECT u FROM userModel u WHERE u.email = ?1 AND u.password = ?2")
	userModel findByUserPass(String email, String pass);
	
	@Query("SELECT u FROM userModel u WHERE u.email = ?1")
	userModel findByUserEmail(String email);

}
