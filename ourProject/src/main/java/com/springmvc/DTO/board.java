package com.springmvc.DTO;

import java.util.Date;

public class Board 
{
	private int number;
	private String Date;
	private String subject;
	private String category;
	private int viewCount;
	private Date supportDeadline;
	private boolean isOverDeadline;
	
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
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public Date getSupportDeadline() {
		return supportDeadline;
	}
	public void setSupportDeadline(Date supportDeadline) {
		this.supportDeadline = supportDeadline;
	}
	
	public Board toEntity() {
		Board board = new Board();
		board.setSubject(this.subject);
		board.setDate(this.Date);
		board.setCategory(this.category);
		return board;
	}

	public Board() {}
}
