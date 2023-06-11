package com.dsaProject.DSAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsaProject.DSAproject.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{

}
