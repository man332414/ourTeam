package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.DTO.parentingDiary;
import com.springmvc.repository.ParentingDiaryRepository;

@Service
public class ParentingDiaryServiceImpl implements ParentingDiaryService {

	@Autowired
	private ParentingDiaryRepository parentingDiaryRepository;

	public ParentingDiaryServiceImpl() {
		
		return ;
	}
	
	@Override
	public List<parentingDiary> getALLparentingDiary() {
		System.out.println("ParentingDiaryServiceImpl 진입");
		return parentingDiaryRepository.getALLparentingDiary();
	}

	@Override
	public parentingDiary getparentingDiaryById(int id) {
		System.out.println("getparentingDiaryById: 진입");
		return parentingDiaryRepository.getparentingDiaryById(id);
	}

	@Override
	public void setNewparentingDiary(parentingDiary parentingDiary) {
		parentingDiaryRepository.setNewparentingDiary(parentingDiary);
	}

	@Override
	public void setUpdateparentingDiary(parentingDiary parentingDiary) {
		// TODO Auto-generated method stub

	}	
	
	@Override
	public void deleteDiary(int id) {
		// TODO Auto-generated method stub
		parentingDiaryRepository.deleteById(id);
	}

}
