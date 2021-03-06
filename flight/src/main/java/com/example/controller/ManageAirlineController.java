package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.FlightNotFoundException;
import com.example.model.AirlineModel;
import com.example.service.ManageAirlineService;

import io.swagger.annotations.ApiOperation;
	
@RestController
@RequestMapping("/API/airlineController")
@CrossOrigin
public class ManageAirlineController {
	@Autowired
	private ManageAirlineService service;

	@GetMapping("")
	@Cacheable(value = "airlines")
	@ApiOperation(
	        value = "Find all airlines",
	        notes = "Header is not required",
	        response = List.class
	    )
	public List<AirlineModel> getAirlines() {
		return service.getallAirlines();
	}
	@PostMapping("")
	public AirlineModel saveAirline(@RequestBody AirlineModel airlineModel) {
		return service.addAirline(airlineModel);
	}

	@GetMapping("/{id}")
	public AirlineModel FindAirlineId(@PathVariable int id) throws FlightNotFoundException {
		return service.findAirlineById(id);
	}
	
	@DeleteMapping("/{id}")
	public boolean DeleteAirlineId(@PathVariable int id) throws FlightNotFoundException {
		return service.deleteAirlne(id);
	}
	
	@PutMapping("/{id}")
	public AirlineModel updateAirline(@RequestBody AirlineModel newAirline,@PathVariable int id) throws FlightNotFoundException {
		return service.updateAirlinebyId(id,newAirline);
	}

	@GetMapping("test")
	public String saveAirline() {
		return "Hi";
	}

	/*
	 * @GetMapping("/{id}") //@Cacheable(key="#id", value="books",
	 * condition="#id==4") public AirlineModel findAirlineById(@PathVariable int
	 * id){ System.out.println("finding book ("+id+") from db"); return
	 * service.findAirlineById(id); }
	 */

}
