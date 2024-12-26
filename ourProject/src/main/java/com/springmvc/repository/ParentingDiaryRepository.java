package com.springmvc.repository;

import java.util.List;

import com.springmvc.DTO.parentingDiary;

public interface ParentingDiaryRepository {

	List<parentingDiary> getALLparentingDiary(); //ok
	parentingDiary getparentingDiaryById(int id);

	public void setNewparentingDiary(parentingDiary parentingDiary);
	public void setUpdateparentingDiary(parentingDiary parentingDiary);

	public void deleteById(int id); //ajax



}
