package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.DAO.service.memberService;
import com.springmvc.DTO.Member;

@Controller
public class memberController 
{
	@Autowired
	private memberService memberService;
	
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
		return "redirect:/signIn";
	}
	
	@GetMapping("/updateMember")
	public String updateMemberForm(@ModelAttribute Member member, @RequestParam("userId") String userId, Model model)
	{
		System.out.println("memberComtroller.updateMemberForm 입장 : " + userId);
		Member memberById = memberService.getMemberById(userId); 
		System.out.println("모델 다녀왔는데 뭐 가져왔어 ?" + memberById.getUserId());
		model.addAttribute("member", memberById);
		return "updateMemberForm";
	}
	
	@PostMapping("/updateMember")
	public String updateMember(@ModelAttribute Member member, Model model)
	{
		System.out.println("memberComtroller.updateMember 입장");
		memberService.updateMember(member);
		return "redirect:/updateMember?UserId="+member.getUserId();
	}
	
}