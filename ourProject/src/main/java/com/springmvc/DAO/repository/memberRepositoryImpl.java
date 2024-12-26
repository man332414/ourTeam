package com.springmvc.DAO.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.DTO.Member;

@Repository
public class memberRepositoryImpl implements memberRepository
{

	private JdbcTemplate template;

	// jdbc 연결
	@Autowired
	public void setJdbctemplate(DataSource dataSource)
	{
		this.template=new JdbcTemplate(dataSource);
	}

	// -------------------------------------- 생성 --------------------------------------
	@Override
	public void addNewMemver(Member member)
	{
		System.out.println("memberRepository.addNewMember 입장");
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(sql, member.getUserId(), member.getPassword(), member.getEmail(), member.getName(), member.getNikName(), member.getBabyBirthDay(), member.getTelecom(), member.getPhone());
	}

	// -------------------------------------- 하나만 읽어오기 --------------------------------------
	@Override
	public Member getMemberById(String userId)
	{
		System.out.println("memberRepository.getMemberById 입장");
		String sql = "select * from member where userId = ?";
		Member memberById = template.queryForObject(sql, new Object[]{userId}, new memberRowMapper());
		System.out.println(memberById.getUserId());
		return memberById;
	}

	// -------------------------------------- 수정 --------------------------------------
	@Override
	public void updateMember(Member member)
	{
		if(member.getPassword()!=null && !member.getPassword().isEmpty())
		{
			System.out.println("memberRepositroy.updateMember 비밀번호 있음 : " + member.getPassword());
			String sql = "update member set password=?, email=?, name=?, nikName=?, babyBirthDay=?, telecom=?, phone=? where userId=?";
			template.update(sql, member.getPassword(), member.getEmail(), member.getName(), member.getNikName(), member.getBabyBirthDay(), member.getTelecom(), member.getPhone(), member.getUserId());
		}
		else if(member.getPassword() == null || member.getPassword().isEmpty())
		{
			System.out.println("memberRepositroy.updateMember 비밀번호 없음 : " + member.getPassword());
			String sql = "update member set email=?, name=?, nikName=?, babyBirthDay=?, telecom=?, phone=? where userId=?";
			template.update(sql, member.getEmail(), member.getName(), member.getNikName(), member.getBabyBirthDay(), member.getTelecom(), member.getPhone(), member.getUserId());
		}
	}

	// -------------------------------------- 삭제 --------------------------------------
	@Override
	public void deleteMember(String userId)
	{
		System.out.println("memberRepository.deleteMember 입장");
		String sql = "delete from member where userId=?";
		template.update(sql, userId);
	}

	// -------------------------------------- 중복검사 --------------------------------------
	@Override
	public int isDuplicate(String userId)
	{
		String sql = "select count(*) from member where userId=?";
		int cont = template.queryForObject(sql, new Object[] {userId}, Integer.class);

		return cont;
	}

	// -------------------------------------- 모두 읽어오기 --------------------------------------
	@Override
	public List<Member> readAllMember()
	{
		System.out.println("memberRepository.readAllMember 입장");
		String sql = "select * from member";
		List<Member> members = template.query(sql, new memberRowMapper());

		return members;
	}

}
