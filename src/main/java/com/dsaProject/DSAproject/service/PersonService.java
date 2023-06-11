package com.dsaProject.DSAproject.service;

import com.dsaProject.DSAproject.entity.Person;

public interface PersonService {

	Person findByPersonEmail(String personEmail);

	void save(Person person);

}
