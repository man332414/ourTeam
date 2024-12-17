package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
 
import com.springmvc.DTO.buyCheckList;

public interface BuyCheckListRepository    {
	List<buyCheckList> getALLbuyCheckList(); //ok

	List<buyCheckList> getbuyCheckListByuseCategory(String useCategory);
	List<buyCheckList> getbuyCheckListByChange(String ischanged);
	buyCheckList getbuyCheckListkByNum(int number);
	void setNewbuyCheckList(buyCheckList buyCheckList);
	void setUpdatebuyCheckList(buyCheckList buyCheckList);
	void setDeletebuyCheckList(int number);

}