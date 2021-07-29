package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.AirlineModel;

public interface AirlineRepository extends JpaRepository<AirlineModel, Integer>{

}
