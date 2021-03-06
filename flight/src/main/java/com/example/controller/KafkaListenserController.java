package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.bookingModel;
import com.example.service.KafkaConsumerListener;

@RestController
@RequestMapping("/API/report")
@CrossOrigin
public class KafkaListenserController {
	
	@Autowired
	private KafkaConsumerListener service;
	
	@GetMapping("")
	public List<bookingModel> getReport() {
		return service.getBookingDetails();
	}

}
