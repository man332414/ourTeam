package com.springmvc.DAO.service;

import java.util.List;

import com.springmvc.DTO.Member;

public interface memberService 
{
	void addNewMember(Member member);

	Member getMemberById(String userId);

	void updateMember(Member member);

	void deleteMember(String userId);

	int isDuplicate(String userId);

	List<Member> readAllMember();
}
