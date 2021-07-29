package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.bookingModel;

@Repository
public interface bookingRepository extends JpaRepository<bookingModel, Integer>{
	
	@Query("SELECT u FROM bookingModel u WHERE u.userid = ?1")
	List<bookingModel> findBookingByUser(int userid);
}
