package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.discountModel;

public interface DiscountRepository extends JpaRepository<discountModel, Integer>{

}
