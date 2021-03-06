package com.example.model;

import javax.persistence.Embeddable;

@Embeddable
public class Passenger {
	private String fullname;
	private int age;
	private String gender;
	private String mealType;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public Passenger(String fullname, int age, String gender, String mealType) {
		this.fullname = fullname;
		this.age = age;
		this.gender = gender;
		this.mealType = mealType;
	}
	public Passenger() {
		
	}
	@Override
	public String toString() {
		return "Passenger [fullname=" + fullname + ", age=" + age + ", gender=" + gender + ", mealType=" + mealType
				+ "]";
	}
	
	
}
