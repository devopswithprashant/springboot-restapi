package com.devopswithprashant.api.test.service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.devopswithprashant.api.test.entities.Blog;

@Component
public class BlogService {

    private static List<Blog> list = new ArrayList<>();

    static {
        list.add(new Blog(2875, "git roadmap", "this is my content of git", "Verma, Shreya", "11-08-2023", "31-01-2024"));
        list.add(new Blog(2345, "DevOps roadmap", "This is my test body content", "Prajapati, Prashant", "31-10-2022", "10-06-2023"));
        list.add(new Blog(56535, "linux roadmap", "this is my content of linux", "Prajapati, Prashant", "11-05-2021", "01-01-2024"));
        list.add(new Blog(98875, "networking roadmap", "this is my content of networking", "Verma, Shreya", "11-08-2020", "31-01-2021"));
    }

    // get all blog
    public List<Blog> getAllBlogs() {
        return list;
    }

    // get specific blog by ID 
    public Blog getBlogById(int id) {
        Blog blog = null;
        blog=list.stream().filter(e->e.getId()==id).findFirst().get();
        return blog;
    }

    //adding the blog
    public void addBlog(Blog blog) {
        list.add(blog);
    }

    //delete the blog
    public void deleteblog(int id) {
        list=list.stream().filter(blog -> blog.getId() != id).collect(Collectors.toList());
    }

    public void updateblog(Blog blog, int id) {
        list = list.stream().map(b-> {
            if(b.getId() == id) {
                b.setTitle(blog.getTitle());
                b.setBody(blog.getBody());
                b.setAuthor(blog.getAuthor());
                b.setLastupdatedate(blog.getLastupdatedate());
                b.setPublishdate(blog.getPublishdate());
            }
            return b;
        }).collect(Collectors.toList());
    }

}
