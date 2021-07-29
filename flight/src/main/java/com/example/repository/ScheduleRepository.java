package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.scheduleModel;


public interface ScheduleRepository extends JpaRepository<scheduleModel, Integer>{
	@Query("SELECT u FROM scheduleModel u WHERE u.source = ?1 AND u.destination = ?2 AND u.date = ?3")
	List<scheduleModel> findAllbyParam(String src, String des, String date);

}
