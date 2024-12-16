package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class homeController 
{
//	--------------------------------- 집으로 가기 ---------------------------------

	@GetMapping
	public String goHomedefault()
	{
		return "home";
	}
	
	@GetMapping("/home")
	public String goHome()
	{
		return "home";
	}
}
