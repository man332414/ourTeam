package com.springmvc.service;

import java.util.List;

import java.util.Map;
import java.util.Set;


import com.springmvc.DTO.buyCheckList;

public interface BuyCheckListService {
	
	List<buyCheckList> getALLbuyCheckList(); //ok

	List<buyCheckList> getbuyCheckListByChange(String ischanged);
	buyCheckList getbuyCheckListkByNum(int number);

	List<buyCheckList> getbuyCheckListByuseCategory(String useCategory);
	Set<buyCheckList> getbuyCheckListByFilter(Map<String,List<String>> filter);

	public void setNewbuyCheckList(buyCheckList buyCheckList);
	public void setUpdatebuyCheckList(buyCheckList buyCheckList);
	public void setDeletebuyCheckList(int number);

}
