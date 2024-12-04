package com.springmvc.DAO.repository;

import java.util.List;

import org.springframework.ui.Model;

import com.springmvc.DTO.Member;

public interface memberRepository 
{
	void addNewMemver(Member member);

	Member getMemberById(String userId);

	void updateMember(Member member);

	void deleteMember(String userId);

	int isDuplicate(String userId);

	List<Member> readAllMember();
}
