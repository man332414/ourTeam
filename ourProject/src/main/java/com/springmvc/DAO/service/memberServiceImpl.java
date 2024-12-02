package com.springmvc.DAO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.DAO.repository.memberRepository;
import com.springmvc.DTO.Member;

@Service
public class memberServiceImpl implements memberService 
{
	@Autowired
	private memberRepository memberRepository;
	
	@Override
	public void addNewMember(Member member) 
	{
		memberRepository.addNewMemver(member);		
	}

	@Override
	public Member getMemberById(String userId) 
	{
		Member memberById = memberRepository.getMemberById(userId);
		return memberById;
	}

	@Override
	public void updateMember(Member member) 
	{
		memberRepository.updateMember(member);
	}

}
