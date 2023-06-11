package com.dsaProject.DSAproject.entity;

import java.util.List;

public interface BlogService {

	void save(Blog blog);

	List<Blog> findAll();

}
