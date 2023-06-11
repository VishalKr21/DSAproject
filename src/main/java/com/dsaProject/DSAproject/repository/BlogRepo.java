package com.dsaProject.DSAproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsaProject.DSAproject.entity.Blog;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long>{

}
