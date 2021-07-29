package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.FlightNotFoundException;
import com.example.model.AirlineModel;
import com.example.repository.AirlineRepository;

@Service
public class ManageAirlineService {
	@Autowired
	private AirlineRepository repository;

	public AirlineModel addAirline(AirlineModel airline) {
		return repository.save(airline);
	}

	public List<AirlineModel> getallAirlines() {
		return repository.findAll();
	}

	public AirlineModel findAirlineById(int id) throws FlightNotFoundException{
		System.out.println("in service id: " + id);
		Optional<AirlineModel> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new FlightNotFoundException("Airline with id: " +id+" is not found in db");
			//return null;
		}
	}
	public boolean deleteAirlne(int id) throws FlightNotFoundException {
		if (repository.existsById(id)) {
			this.repository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	public AirlineModel updateAirlinebyId(int id,AirlineModel airline) throws FlightNotFoundException
	{
		return repository.findById(id)
	            .map(existAirline -> {
	            	existAirline.setAirlinename(airline.getAirlinename());
	            	existAirline.setLogo(airline.getLogo());
	            	existAirline.setLogo(airline.getLogo());
	            	existAirline.setContactNum(airline.getContactNum());
	            	existAirline.setContactAddress(airline.getContactAddress());
	                return repository.save(existAirline);
	            })
	            .orElseGet(() -> {
	                return null;
	            });
	}
	/*public boolean deleteSchedule(Long id) {

        boolean isRemoved = this.repository.removeIf(post -> post.getId().equals(id));

        return isRemoved;
    }
	public AirlineModel UdateAirlineById(int id) {
		System.out.println("in service id: " + id);
		Optional<AirlineModel> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}*/
	
}
