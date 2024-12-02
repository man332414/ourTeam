package com.springmvc.DTO;

import java.util.Date;

public class board 
{
	int number;
	String Date;
	String subject;
	String category;
	String viewCount;
	Date supportDeadline;
	boolean isOverDeadline;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getViewCount() {
		return viewCount;
	}
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	public Date getSupportDeadline() {
		return supportDeadline;
	}
	public void setSupportDeadline(Date supportDeadline) {
		this.supportDeadline = supportDeadline;
	}
}
