package com.devopswithprashant.api.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devopswithprashant.api.test.entities.Blog;
import com.devopswithprashant.api.test.service.BlogService;





@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public List<Blog> getBlogs() {
        return this.blogService.getAllBlogs();
    }

    @GetMapping("/blogs/{id}")
    public Blog getBlog(@PathVariable("id") int id) {
        return blogService.getBlogById(id);
    }

}
