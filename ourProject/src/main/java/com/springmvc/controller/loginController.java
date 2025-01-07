package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.DAO.service.memberService;
import com.springmvc.DTO.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class loginController 
{
	@Autowired
	memberService memberService;
	
	@GetMapping("/login")
	public String loginForm(Model model, HttpServletRequest req)
	{
		System.out.println("loginForm() 입장 : ");
		HttpSession session = req.getSession(false);
		if(session != null) 
		{			
			session.invalidate();
		}
		System.out.println("------------------------------------------");
		return "login";
	}
	
	@PostMapping("/login")
	public String loginConfirm(@RequestParam String userId, @RequestParam String password, HttpServletRequest req)
	{
		System.out.println("loginController.loginConfirm() 입장 " + userId);
		
		Member member = memberService.getLoginMember(userId, password);
		System.out.println("서비스 다녀왔는데 뭐 가져온거 있어? " + member.getUserId());
		if(member != null && !member.toString().isEmpty())
		{
			System.out.println("리파지토리에 있네요 login 처리 시작");
			HttpSession session = req.getSession(true);
			session.setAttribute("member", member);
			System.out.println("------------------------------------------");
			return "redirect:/";
		}
		else
		{
			System.out.println("리파지토리에 없는 아이디 입니다.");
			System.out.println("------------------------------------------");
			return "redirect:/login?error=true";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req)
	{
		HttpSession session = req.getSession(false);
		
		if(session != null)
		{
			session.invalidate();
		}
		
		return "redirect:/";
	}
//		System.out.println("loginController.loginSuccess() 입장");
//		HttpSession session = req.getSession(false);
//        // 현재 인증된 사용자 정보 가져오기
//		if(session!=null) 
//		{
//	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	        User userInfom = (User) authentication.getPrincipal();
//	        String userId = userInfom.getUsername();
//	        System.out.println("userId : " + userId);
//
//			try
//			{
//				Member memberById = memberService.getMemberById(userId);
//				System.out.println("모델 다녀왔는데 뭐 가져왔어? " + memberById.getUserId());
//				session.setAttribute("member", memberById);
//			} 
//			catch (Exception e) 
//			{
//				e.printStackTrace();
//			}
//			
////			String auth = userInfom.getAuthorities().toString();
////			System.out.println("auth to String : " + auth);
////			session.setAttribute("auth", auth);
//		}
//		
//		System.out.println("------------------------------------------");
//		return "home";
		
}
