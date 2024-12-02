package com.springmvc.DAO.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.DTO.Member;

@Repository
public class memberRepositoryImpl implements memberRepository 
{
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbctemplate(DataSource dataSource)
	{
		this.template=new JdbcTemplate(dataSource);
			
	}
	@Override
	public void addNewMemver(Member member) 
	{
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(sql, member.getUserId(), member.getPassword(), member.getEmail(), member.getName(), member.getNikName(), member.getBabyBirthDay(), member.getTelecom(), member.getPhone());
	}
	
	@Override
	public Member getMemberById(String userId) 
	{
		String sql = "select * from member where userId = ?";
		Member memberById = (Member)template.queryForList(sql, Member.class);
		System.out.println(memberById.getUserId());
		return memberById;
	}
	
	@Override
	public void updateMember(Member member) 
	{
		if(member.getPassword()!=null)
		{
			String sql = "update member set userId=?, password=?, email=?, name=?, nikName=?, babyBirthDay=?, telecom=?, phone=?";
			template.queryForRowSet(sql, member.getUserId(), member.getPassword(), member.getEmail(), member.getName(), member.getNikName(), member.getBabyBirthDay(), member.getTelecom(), member.getPhone());
		}
		else if(member.getPassword() == null)
		{
			String sql = "update member set userId=?, email=?, name=?, nikName=?, babyBirthDay=?, telecom=?, phone=?";
			template.queryForRowSet(sql, member.getUserId(), member.getEmail(), member.getName(), member.getNikName(), member.getBabyBirthDay(), member.getTelecom(), member.getPhone());
		}
	}

	
}
