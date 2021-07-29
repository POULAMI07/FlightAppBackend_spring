package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.scheduleModel;
import com.example.repository.ScheduleRepository;

@Service
public class ManageScheduleService {
	@Autowired
	private ScheduleRepository repository;

	public scheduleModel addSchedule(scheduleModel schedule) {
		return repository.save(schedule);
	}

	public List<scheduleModel> getallSchedule() {
		return repository.findAll();
	}

	public scheduleModel findScheduleById(int id) {
		System.out.println("in service id: " + id);
		Optional<scheduleModel> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	public boolean deleteSchedule(int id) {
		if (repository.existsById(id)) {
			this.repository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	public List<scheduleModel> getSchedulebyParam(String src,String des,String date)
	{
		return repository.findAllbyParam(src,des,date);
	}
	public scheduleModel updateSchedulebyId(int id,scheduleModel schedule)
	{
		return repository.findById(id)
	            .map(existSchedule -> {
	            	existSchedule.setAirlineName(schedule.getAirlineName());
	            	existSchedule.setFlightNum(schedule.getFlightNum());
	            	existSchedule.setSource(schedule.getSource());
	            	existSchedule.setDestination(schedule.getDestination());
	            	existSchedule.setDate(schedule.getDate());
	            	existSchedule.setPrice(schedule.getPrice());
	            	existSchedule.setTime(schedule.getTime());
	                return repository.save(existSchedule);
	            })
	            .orElseGet(() -> {
	                return null;
	            });
	}
	/*public AirlineModel UdateAirlineById(int id) {
		System.out.println("in service id: " + id);
		Optional<AirlineModel> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}*/
	
}
