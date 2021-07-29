package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class scheduleModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String airlineName;
	private String flightNum;
	private String date;
	private String time;
	private String source;
	private String destination;
	private String price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public scheduleModel(String airlineName, String flightNum, String date, String time, String source,
			String destination, String price) {
		this.airlineName = airlineName;
		this.flightNum = flightNum;
		this.date = date;
		this.time = time;
		this.source = source;
		this.destination = destination;
		this.price = price;
	}
	public scheduleModel() {
		
	}

	@Override
	public String toString() {
		return "scheduleModel [id=" + id + ", airlineName=" + airlineName + ", flightNum=" + flightNum + ", date="
				+ date + ", time=" + time + ", source=" + source + ", destination=" + destination + ", price=" + price
				+ "]";
	}
	

}
