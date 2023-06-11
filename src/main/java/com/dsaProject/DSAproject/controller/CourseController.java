package com.dsaProject.DSAproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsaProject.DSAproject.entity.Course;
import com.dsaProject.DSAproject.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("")
	public String course(Model model)
	{
		List<Course> courses = courseService.findAll();
		model.addAttribute("courses", courses);
		return "courses";
	}
	
	@GetMapping("/new")
	public String newCourse(Model model, Authentication authentication)
	{		
		if(authentication==null || authentication.getAuthorities().toString().equals("[ROLE_USER]")) return "redirect:/";
		
		model.addAttribute("course", new Course());
		return "newCourse";
	}
	
	@PostMapping("/new")
	public String saveCourse(@ModelAttribute("Course") Course course, Authentication authentication) 
	{
		//System.out.println(course);
		if(authentication==null || authentication.getAuthorities().toString().equals("[ROLE_USER]")) return "redirect:/";
		courseService.save(course);
		return "redirect:/";
	}
	
	@GetMapping("/{coursesId}")
	public String detailCourse(@PathVariable("coursesId") long coursesId, Model model)
	{
		Optional<Course> course = courseService.findById(coursesId);
		if(course==null)return "redirect:/courses";
		model.addAttribute("course", course.get());
		return "courseDetails";
	}

}
