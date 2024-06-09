package com.devopswithprashant.api.test.controller;

import org.springframework.web.bind.annotation.RestController;

import com.devopswithprashant.api.test.entities.Blog;

import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class BlogController {

    @GetMapping("/blog")
    public Blog getBlogs() {
        
        Blog blog = new Blog();
        blog.setId(2345);
        blog.setTitle("DEvOps roadmap");
        blog.setBody("This is my test body content");
        blog.setAuthor("Prajapati, Prashant");
        blog.setPublishdate("31-10-2022");
        blog.setLastupdatedate("10-06-2023");

        return blog;
    }

}
