package com.devopswithprashant.api.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.devopswithprashant.api.test.entities.Blog;

public interface BlogRepository extends CrudRepository<Blog, Integer> {
    
    public Blog findById(int id);
    
}
