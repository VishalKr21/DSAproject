package com.dsaProject.DSAproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsaProject.DSAproject.entity.Person;
import com.dsaProject.DSAproject.repository.PersonRepo;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepo personRepo;

	@Override
	public Person findByPersonEmail(String personEmail) {
		// TODO Auto-generated method stub
		return personRepo.findByPersonEmail(personEmail);
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		personRepo.save(person);
	}

}
