package com.dsaProject.DSAproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsaProject.DSAproject.entity.Course;
import com.dsaProject.DSAproject.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepo courseRepo;

	@Override
	public void save(Course course) {
		// TODO Auto-generated method stub
		courseRepo.save(course);
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

	@Override
	public Optional<Course> findById(long coursesId) {
		// TODO Auto-generated method stub
		return courseRepo.findById(coursesId);
	}

}
