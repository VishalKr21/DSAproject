package com.dsaProject.DSAproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsaProject.DSAproject.entity.Person;
import com.dsaProject.DSAproject.entity.Roles;
import com.dsaProject.DSAproject.service.PersonService;


@Controller
@RequestMapping("/register")
public class PersonController {
	@Autowired
	private PersonService personService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@GetMapping("")
	public String register(Model model,Authentication authentication)
	{
		if(authentication!=null)return "redirect:/";
		model.addAttribute("person", new Person());
		return "register";
	}
	
	@PostMapping("")
	public String register(@ModelAttribute("Person") Person person,Authentication authentication)
	{
		if(authentication!=null)return "redirect:/";
		
		Person p1 = personService.findByPersonEmail(person.getPersonEmail());
		//System.out.println(p1);
		if(p1!=null)return "redirect:/register";
		if(person.getPersonConfirmPassword().equals(person.getPersonPassword())==false)return "redirect:/register";
		person.setPersonConfirmPassword(passwordEncoder.encode(person.getPersonConfirmPassword()));
		person.setPersonPassword(passwordEncoder.encode(person.getPersonPassword()));
		Roles roles = new Roles(); 
		roles.setRole("ROLE_ADMIN");
		person.setRole(roles);
		personService.save(person);
		return "redirect:/login";  
	}
	
}
