package com.springmvc.DTO;

public class Member 
{
	private String userId;
	private String password;
	private String email;
	private String name;
	private String nikName;
	private String babyBirthDay;
	private String telecom;
	private String phone;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNikName() {
		return nikName;
	}
	public void setNikName(String nikName) {
		this.nikName = nikName;
	}
	public String getBabyBirthDay() {
		return babyBirthDay;
	}
	public void setBabyBirthDay(String babyBirthDay) {
		this.babyBirthDay = babyBirthDay;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelecom() {
		return telecom;
	}
	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
