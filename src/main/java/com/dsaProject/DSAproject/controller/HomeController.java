package com.dsaProject.DSAproject.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@GetMapping(value = {"","/"})
	public String home()
	{
		return "index";
	}
	
	@GetMapping("/contact")
	public String contact()
	{
		return "contact";
	}
	
	@RequestMapping(value ="/login",method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Authentication authentication)
	{
		if(authentication!=null)return "redirect:/";
		return "/login";
	}
	
	@GetMapping("/about")
	public String about()
	{
		return "about";
	}
	
	@GetMapping("/logout")
	public String logout()
	{
		return "redirect:/";
	}
	
}
