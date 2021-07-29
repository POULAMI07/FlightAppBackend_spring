package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.model.bookingModel;

@Service
public class KafkaConsumerListener {
	
	private static final String TOPIC = "booking_topic";
	
	private static List<bookingModel> bookingDetails=new ArrayList<bookingModel>();
	
    @KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
    public void consumeBookingDetails(bookingModel booking) {
        System.out.println("Consumed JSON Message: " + booking);
        bookingDetails.add(booking);
        //return booking;
    }
    
    public List<bookingModel> getBookingDetails()
    {
    	System.out.println("Hello booking:"+bookingDetails);
    	return bookingDetails;
    }

}
