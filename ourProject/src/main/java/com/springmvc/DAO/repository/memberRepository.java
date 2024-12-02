package com.springmvc.DAO.repository;

import com.springmvc.DTO.Member;

public interface memberRepository 
{
	void addNewMemver(Member member);

	Member getMemberById(String userId);

	void updateMember(Member member);
}
