package com.example.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class bookingModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int schlId;
	private int userid;
	private String status;
	private int pricepaid;
	private String pnr;
	
	@ElementCollection
	private List<Passenger> passengerinfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSchlId() {
		return schlId;
	}

	public void setSchlId(int schlId) {
		this.schlId = schlId;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPricepaid() {
		return pricepaid;
	}

	public void setPricepaid(int pricepaid) {
		this.pricepaid = pricepaid;
	}

	public List<Passenger> getPassengerinfo() {
		return passengerinfo;
	}

	public void setPassengerinfo(List<Passenger> passengerinfo) {
		this.passengerinfo = passengerinfo;
	}
	
	public String getPNR() {
		return pnr;
	}

	public void setPNR(String pnr) {
		this.pnr = pnr;
	}
	
	
	public bookingModel(int schlId, int userid, String status, int pricepaid, String pnr,
			List<Passenger> passengerinfo) {
		
		this.schlId = schlId;
		this.userid = userid;
		this.status = status;
		this.pricepaid = pricepaid;
		this.pnr = pnr;
		this.passengerinfo = passengerinfo;
	}

	public bookingModel() {}

	@Override
	public String toString() {
		return "bookingModel [id=" + id + ", schlId=" + schlId + ", userid=" + userid + ", status=" + status
				+ ", pricepaid=" + pricepaid + ", pnr=" + pnr + ", passengerinfo=" + passengerinfo + "]";
	}

	

	
	
	
	
}
