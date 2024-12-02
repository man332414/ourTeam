package com.springmvc.DAO.service;

import com.springmvc.DTO.Member;

public interface memberService 
{
	void addNewMember(Member member);

	Member getMemberById(String userId);

	void updateMember(Member member);
}
