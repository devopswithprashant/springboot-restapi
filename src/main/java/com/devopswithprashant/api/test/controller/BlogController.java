package com.devopswithprashant.api.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devopswithprashant.api.test.entities.Blog;
import com.devopswithprashant.api.test.service.BlogService;







@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    //get all blog handler
    @GetMapping("/blogs")
    public List<Blog> getBlogs() {
        return this.blogService.getAllBlogs();
    }

    //get single blog handler
    @GetMapping("/blogs/{id}")
    public Blog getBlog(@PathVariable("id") int id) {
        return blogService.getBlogById(id);
    }

    //add new blog handler
    @PostMapping("/blogs")
    public void addBlog(@RequestBody Blog blog) {
        this.blogService.addBlog(blog);
    }

    //delete a blog by ID
    @DeleteMapping("/blog/{blogID}")
    public void deleteBlog(@PathVariable("blogID") int id) {
        this.blogService.deleteblog(id);
    }
    
    
    
   

}
