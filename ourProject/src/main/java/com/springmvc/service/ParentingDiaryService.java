package com.springmvc.service;

import java.util.List;

import com.springmvc.DTO.parentingDiary;

public interface ParentingDiaryService {
	
	List<parentingDiary> getALLparentingDiary(); //ok
	parentingDiary getparentingDiaryById(int id);
	
	
	public void setNewparentingDiary(parentingDiary parentingDiary);
	public void setUpdateparentingDiary(parentingDiary parentingDiary);
	public void deleteDiary(int id) ; //ajax
	
}
