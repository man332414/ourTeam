package com.springmvc.DAO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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

	@Override
	public void deleteMember(String userId) 
	{
		memberRepository.deleteMember(userId);
	}

	@Override
	public int isDuplicate(String userId) 
	{
		return memberRepository.isDuplicate(userId);
	}

	@Override
	public List<Member> readAllMember() 
	{
		List<Member> members = memberRepository.readAllMember();
		return members;
	}

}
