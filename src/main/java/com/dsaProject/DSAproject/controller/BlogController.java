package com.dsaProject.DSAproject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsaProject.DSAproject.entity.Blog;
import com.dsaProject.DSAproject.entity.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@GetMapping("")
	public String blog(Model model)
	{
		List<Blog> blogs = blogService.findAll();
		System.out.println(blogs);
		model.addAttribute("blogs", blogs);
		return "blog";
	}
	
	@GetMapping("/new")
	public String newPost(Model model, Authentication authentication)
	{
		if(authentication==null || authentication.getAuthorities().toString().equals("[ROLE_USER]")) return "redirect:/";
		model.addAttribute("blog", new Blog());
		return "new_post";
	}
	
	@PostMapping("/new")
	public String newPost(@ModelAttribute("Blog") Blog blog, Authentication authentication) 
	{
		if(authentication==null || authentication.getAuthorities().toString().equals("[ROLE_USER]")) return "redirect:/";
		blog.setBolgDate(new Date());
		blog.setUserName(authentication.getName());
		blogService.save(blog);
		return "redirect:/blog";
	}
}
