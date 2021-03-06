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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.scheduleModel;
import com.example.service.ManageScheduleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/API/scheduleController")
@CrossOrigin
public class ManageScheduleController {
	@Autowired
	private ManageScheduleService service;

	@GetMapping("")
	@Cacheable(value = "schedule")
	@ApiOperation(
	        value = "Find all schedules",
	        notes = "Header is not required",
	        response = List.class
	    )
	public List<scheduleModel> getShedules() {
		return service.getallSchedule();
	}
	@PostMapping("")
	public scheduleModel saveSchedule(@RequestBody scheduleModel schedule) {
		return service.addSchedule(schedule);
	}

	@GetMapping("/{id}")
	public scheduleModel FindScheduleId(@PathVariable int id) {
		return service.findScheduleById(id);
	}

	@GetMapping("/search")
	public List<scheduleModel> getSchedulebyParam(@RequestParam String src,@RequestParam String des,@RequestParam String date) {
		return service.getSchedulebyParam(src,des,date);
	}
	@DeleteMapping("/{id}")
	public boolean DeleteAirlineId(@PathVariable int id) {
		return service.deleteSchedule(id);
	}
	@PutMapping("/{id}")
	public scheduleModel updateSchedule(@RequestBody scheduleModel newschedule,@PathVariable int id) {
		return service.updateSchedulebyId(id,newschedule);
	}
	

}
