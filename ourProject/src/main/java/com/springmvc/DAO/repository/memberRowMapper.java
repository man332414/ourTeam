package com.springmvc.DAO.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.DTO.Member;

public class memberRowMapper implements RowMapper<Member>
{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Member member = new Member();

		member.setUserId(rs.getString("userId"));
		member.setPassword(rs.getString("password"));
		member.setEmail(rs.getString("email"));
		member.setName(rs.getString("name"));
		member.setNikName(rs.getString("nikName"));
		if(rs.getDate("babyBirthDay") != null)
		{
			member.setBabyBirthDay(rs.getDate("babyBirthDay").toLocalDate());
		}
		member.setTelecom(rs.getString("telecom"));
		member.setPhone(rs.getString("phone"));
		member.setRole(rs.getString("role"));

		return member;
	}

}
