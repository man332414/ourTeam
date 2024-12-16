package com.springmvc.DTO;

import java.util.Date;

public class Board 
{
	private int number;
	private String Date;
	private String title;
	private String category;
	private int viewCount;
	private Date supportDeadline;
	private boolean isOverDeadline;
	private String content;
	
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
	
	public Board() {}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
