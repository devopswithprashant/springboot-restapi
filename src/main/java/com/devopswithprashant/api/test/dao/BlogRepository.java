package com.devopswithprashant.api.test.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.devopswithprashant.api.test.entities.Blog;

public interface BlogRepository extends CrudRepository<Blog, Integer> {
    
    public Blog findById(int id);

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Blog b WHERE b.id = :id")
    public boolean isBlogExistById(@Param("id") int id);
    
}
