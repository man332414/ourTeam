package com.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.DAO.service.memberService;
import com.springmvc.DTO.Member;

@Controller("/")
public class memberController 
{
	@Autowired
	private memberService memberService;
	
//	--------------------------------- 집으로 가기 ---------------------------------

	@GetMapping
	public String goHome()
	{
		return "home";
	}

//	--------------------------------- 회원가입 ---------------------------------
	
	@GetMapping("/signIn")
	public String memberForm(@ModelAttribute Member member, Model modle)
	{
		return "memberForm";
	}
	
	@PostMapping("/signIn")
	public String addMember(@ModelAttribute Member member, Model modle)
	{
		System.out.println("memberController.addMember 입장 : " +member.getUserId());
		memberService.addNewMember(member);
		System.out.println("------------------------------------------");
		
		return "home";
	}
	
	@PostMapping("isDuplicate")
	public ResponseEntity<Map<String,String>> isDuplicate(@RequestBody Map<String, String> MapUserId)
	{
		System.out.println("controller.isDuplicate : "+MapUserId.get("userId"));
		String userId = MapUserId.get("userId");
		Map<String, String> response = new HashMap<String, String>();
		
		int isDupl = memberService.isDuplicate(userId);
		if(isDupl >= 1)
		{
			response.put("isDuplicate", "true");
		}
		else
		{
			response.put("isDuplicate", "false");
		}
		
		System.out.println("뭐가들었나 꺼내보자 : "+response.get("isDuplicate"));
		System.out.println("------------------------------------------");

		return ResponseEntity.ok(response);
	}

//	--------------------------------- 회원정보 업데이트 ---------------------------------
	
	@GetMapping("/updateMember")
	public String updateMemberForm(@ModelAttribute Member member, @RequestParam("userId") String userId, Model model)
	{
		System.out.println("memberComtroller.updateMemberForm 입장 ");
		Member memberById = memberService.getMemberById(userId); 
		System.out.println("모델 다녀왔는데 뭐 가져왔어? " + memberById.getUserId());
		model.addAttribute("member", memberById);
		System.out.println("------------------------------------------");
		
		return "updateMemberForm";
	}
	
	@PostMapping("/updateMember")
	public String updateMember(@ModelAttribute Member member, Model model)
	{
		System.out.println("memberComtroller.updateMember 입장 : " + member.getUserId());
		memberService.updateMember(member);
		System.out.println("------------------------------------------");
		
		return "redirect:/updateMember?userId="+member.getUserId();
	}

//	--------------------------------- 회원정보 삭제 ---------------------------------	
	
	@GetMapping("/deleteMember")
	public String deleteMember(@RequestParam("userId") String userId, Model model) 
	{
		System.out.println("controller.deleteMember 입장 : " + userId);
		memberService.deleteMember(userId);
		System.out.println("------------------------------------------");
		
		return "home";
	}
}