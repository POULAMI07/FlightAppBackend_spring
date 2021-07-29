package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirlineModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String airlinename;
	private String logo;
	private String contactNum;
	private String contactAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirlinename() {
		return airlinename;
	}

	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public AirlineModel( String airlinename, String logo, String contactNum, String contactAddress) {
		
		this.airlinename = airlinename;
		this.logo = logo;
		this.contactNum = contactNum;
		this.contactAddress = contactAddress;
	}

	public AirlineModel() {

	}

	@Override
	public String toString() {
		return "AirlineModel [id=" + id + ", airlinename=" + airlinename + ", logo=" + logo + ", contactNum="
				+ contactNum + ", ContactAddress=" + contactAddress + "]";
	}

}
