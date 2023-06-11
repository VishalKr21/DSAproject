package com.dsaProject.DSAproject.service;

import java.util.List;
import java.util.Optional;

import com.dsaProject.DSAproject.entity.Course;

public interface CourseService {

	void save(Course course);

	List<Course> findAll();

	Optional<Course> findById(long coursesId);

}
