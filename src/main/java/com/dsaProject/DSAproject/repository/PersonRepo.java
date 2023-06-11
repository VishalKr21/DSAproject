package com.dsaProject.DSAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsaProject.DSAproject.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long>{

	Person findByPersonEmail(String personEmail);

}
