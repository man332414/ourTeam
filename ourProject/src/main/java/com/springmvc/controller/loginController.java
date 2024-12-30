package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.DAO.service.memberService;
import com.springmvc.DTO.Member;

@Controller
public class loginController 
{
	@Autowired
	memberService memberService;
	
	@GetMapping("/login")
	public String loginForm(@RequestParam(value="error", defaultValue="false") String error, Model model, HttpServletRequest req)
	{
		System.out.println("loginForm() 입장 : " + error);
		HttpSession session = req.getSession(false);
		if(session != null) 
		{			
			session.invalidate();
		}
		model.addAttribute("error", error);
		System.out.println("------------------------------------------");
		return "login";
	}
	
	@GetMapping("/loginSuccess")
	public String loginSuccess(Model model, HttpServletRequest req)
	{
		System.out.println("loginController.loginSuccess() 입장");
		HttpSession session = req.getSession(false);
        // 현재 인증된 사용자 정보 가져오기
		if(session!=null) 
		{
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String userId = ((User) authentication.getPrincipal()).getUsername();
	        System.out.println("userId : " + userId);
			try
			{
				Member memberById = memberService.getMemberById(userId);
				System.out.println("모델 다녀왔는데 뭐 가져왔어? " + memberById.getUserId());
				session.setAttribute("member", memberById);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("------------------------------------------");

		return "home";
	}
		
	@GetMapping("/logoutSuccess")
	public String logoutSuccess()
	{
		System.out.println("------------------------------------------");
		return "home";
	}
}
