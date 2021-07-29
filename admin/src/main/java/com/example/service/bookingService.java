package com.example.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.bookingModel;
import com.example.repository.bookingRepository;

@Service
public class bookingService {
	@Autowired
	private bookingRepository repository;

	public bookingModel addBooking(bookingModel booking) {
		return repository.save(booking);
	}
	public List<bookingModel> getallBooking() {
		return repository.findAll();
	}

	public bookingModel findBookingById(int id) {
		//System.out.println("in user service id: " + id);
		Optional<bookingModel> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	public boolean deleteBooking(int id) {
        if (repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
	public List<bookingModel> findBookingByUser(int userid)
	{
		return repository.findBookingByUser(userid);
	}
	
	public bookingModel cancelBooking(int id,bookingModel details)
	{
		return repository.findById(id)
	            .map(existbooking -> {
	            	existbooking.setSchlId(details.getSchlId());
	            	existbooking.setUserid(details.getUserid());
	            	existbooking.setPassengerinfo(details.getPassengerinfo());
	            	existbooking.setStatus(details.getStatus());
	            	existbooking.setPricepaid(details.getPricepaid());
	                return repository.save(existbooking);
	            })
	            .orElseGet(() -> {
	                return null;
	            });
	}

}
