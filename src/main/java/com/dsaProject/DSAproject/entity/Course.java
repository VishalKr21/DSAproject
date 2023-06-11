package com.dsaProject.DSAproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long courseId;
	private String courseType;
	private String courseTitle;
	private String courseShortDesc;
	private String courseLongDesc;
	private long courseLike;
	private long courseCount;
	private long coursePrice;

}
