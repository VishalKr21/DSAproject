package com.dsaProject.DSAproject.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsaProject.DSAproject.repository.BlogRepo;

@Service
public class BlogServiceImpl implements BlogService{
	@Autowired
	private BlogRepo blogrepo;
	@Override
	public void save(Blog blog) {
		// TODO Auto-generated method stub
		blogrepo.save(blog);
	}
	@Override
	public List<Blog> findAll() {
		// TODO Auto-generated method stub
		return blogrepo.findAll();
	}

}
