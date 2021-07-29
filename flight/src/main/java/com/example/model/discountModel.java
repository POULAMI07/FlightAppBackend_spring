package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class discountModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String discount;
	private int discountPer;
	private int maxdiscount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public int getDiscountPer() {
		return discountPer;
	}
	public void setDiscountPer(int discountPer) {
		this.discountPer = discountPer;
	}
	public int getMaxdiscount() {
		return maxdiscount;
	}
	public void setMaxdiscount(int maxdiscount) {
		this.maxdiscount = maxdiscount;
	}
	public discountModel(String discount, int discountPer, int maxdiscount) {
		this.discount = discount;
		this.discountPer = discountPer;
		this.maxdiscount = maxdiscount;
	}
	public discountModel() {}
	@Override
	public String toString() {
		return "discountModel [id=" + id + ", discount=" + discount + ", discountPer=" + discountPer + ", maxdiscount="
				+ maxdiscount + "]";
	}

}
