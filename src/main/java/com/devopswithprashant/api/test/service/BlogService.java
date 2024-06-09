package com.devopswithprashant.api.test.service;
import com.devopswithprashant.api.test.entities.Blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BlogService {

    private static List<Blog> list = new ArrayList<>();

    static {
        list.add(new Blog(2875, "git roadmap", "this is my content of git", "Verma, Shreya", "11-08-2023", "31-01-2024"));
        list.add(new Blog(2345, "DevOps roadmap", "This is my test body content", "Prajapati, Prashant", "31-10-2022", "10-06-2023"));
        list.add(new Blog(56535, "linux roadmap", "this is my content of linux", "Prajapati, Prashant", "11-05-2021", "01-01-2024"));
        list.add(new Blog(98875, "networking roadmap", "this is my content of networking", "Verma, Shreya", "11-08-2020", "31-01-2021"));
    }

    public List<Blog> getAllBlogs() {
        return list;
    }

    public Blog getBlogById(int id) {
        Blog blog = null;
        blog=list.stream().filter(e->e.getId()==id).findFirst().get();
        return blog;
    }

}
