package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.DTO.buyCheckList;
import com.springmvc.DTO.emergencyRoom;
import com.springmvc.repository.BuyCheckListRepository;

@Service
public class BuyCheckListServiceImpl implements BuyCheckListService {
	
	@Autowired
	private BuyCheckListRepository buyCheckListRepository;

	public BuyCheckListServiceImpl() {
		
		return ;
	}
	
	@Override
	public List<buyCheckList> getALLbuyCheckList() {
		// TODO Auto-generated method stub
		System.out.println("BuyCheckListServiceImpl 진입");
		return buyCheckListRepository.getALLbuyCheckList();
	}

	 

	@Override
	public List<buyCheckList> getbuyCheckListByChange(String ischanged) {

		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public buyCheckList getbuyCheckListkByNum(int number) {
	// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNewbuyCheckList(buyCheckList buyCheckList) {
	
		buyCheckListRepository.setNewbuyCheckList(buyCheckList);
		
	}

	@Override
	public void setUpdatebuyCheckList(buyCheckList buyCheckList) {
		System.out.println("130.BuyCheckListServiceImpl setUpdatebuyCheckListk: 진입");
		buyCheckListRepository.setUpdatebuyCheckList(buyCheckList);
	}

	@Override
	public void setDeletebuyCheckList(int number) {
		System.out.println("140.BuyCheckListServiceImpl setDeletebuyCheckList: 진입");
		buyCheckListRepository.setDeletebuyCheckList(number);
		
	}

	@Override
	public List<buyCheckList> getbuyCheckListByuseCategory(String useCategory) {
		List<buyCheckList> listsByuseCategory = buyCheckListRepository.getbuyCheckListByuseCategory(useCategory);
		
		return listsByuseCategory;
	}

	@Override
	public Set<buyCheckList> getbuyCheckListByFilter(Map<String, List<String>> filter) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
