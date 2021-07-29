package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.bookingModel;
import com.example.service.bookingService;


@RestController
@RequestMapping("bookingController")
@CrossOrigin
public class BookingController {
	
	@Autowired
    private KafkaTemplate<String, bookingModel> kafkaTemplate;
	
	private static final String TOPIC = "booking_topic";
	
	@Autowired
	private bookingService service;
	
	@PostMapping("")
	public bookingModel saveBooking(@RequestBody bookingModel booking) {
		System.out.println("booking");
		bookingModel obj = service.addBooking(booking);
		kafkaTemplate.send(TOPIC, obj);
		return obj;
		//return service.addBooking(booking);
	}
	
	@GetMapping("")
	@Cacheable(value = "booking")
	public List<bookingModel> getBookings() {
		
		return service.getallBooking();
	}
	@GetMapping("/{id}")
	public bookingModel FindBookingId(@PathVariable int id) {
		return service.findBookingById(id);
	}
	@GetMapping("user")
	public List<bookingModel> FindBookinguser(@RequestParam int userid) {
		return service.findBookingByUser(userid);
	}
	@PutMapping("cancelbooking/{id}")
	public bookingModel cancelBooking(@RequestBody bookingModel details,@PathVariable int id) {
		return service.cancelBooking(id,details);
	}
	
	
	

}
