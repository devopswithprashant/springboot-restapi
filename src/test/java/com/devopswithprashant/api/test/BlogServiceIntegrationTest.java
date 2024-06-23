package com.devopswithprashant.api.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.devopswithprashant.api.test.dao.BlogRepository;
import com.devopswithprashant.api.test.entities.Blog;
import com.devopswithprashant.api.test.service.BlogService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BlogServiceIntegrationTest {
    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogRepository blogRepository;

    @BeforeEach
    public void setUp() {
        // Set up test data
        //Blog b1 = new Blog(2875, "git roadmap", "this is my content of git", "Verma, Shubham", "11-08-2023", "31-01-2024");
		// 	Blog b2 = new Blog(56535, "linux roadmap", "this is my content of linux", "Prajapati, Mohit", "11-05-2021", "01-01-2024");

        Blog blog1 = new Blog();
        blog1.setId(1);
        blog1.setTitle("First Blog");
        blog1.setBody("This is the first blog.");
        blog1.setAuthor("Bob");
        blog1.setPublishdate("31-10-2022");
        blog1.setLastupdatedate("23-09-2023");
        blogRepository.save(blog1);

        Blog blog2 = new Blog();
        blog1.setId(2);
        blog2.setTitle("Second Blog");
        blog2.setBody("This is the second blog.");
        blog2.setAuthor("William, Sean");
        blog2.setPublishdate("03-10-2010");
        blog2.setLastupdatedate("23-09-2013");
        blogRepository.save(blog2);
    }

     @Test
    public void testGetAllBlogs() {
        // Act
        List<Blog> blogs = blogService.getAllBlogs();
        
        // Assert
        assertNotNull(blogs);
        assertEquals(2, blogs.size());
    }

    @Test
    public void testGetBlogById_BlogExists() {
        //List<Blog> blogs = blogService.getAllBlogs();
        // Arrange
        //int blogId = 1;
        int blogId = blogService.getAllBlogs().get(0).getId();
        System.out.println(blogId);
        // Act
        Blog foundBlog = blogService.getBlogById(blogId);

        // Assert
        assertNotNull(foundBlog);
        assertEquals(blogId, foundBlog.getId());
    }

    @Test
    public void testGetBlogById_BlogDoesNotExist() {
        // Arrange
        int blogId = 99;

        // Act
        Blog foundBlog = blogService.getBlogById(blogId);

        // Assert
        assertNull(foundBlog);
    }

    @Test
    public void testAddBlog() {
        // Arrange
        Blog newBlog = new Blog();
        newBlog.setTitle("New Blog");
        newBlog.setBody("This is a new blog.");
        newBlog.setAuthor("Sohail");
        newBlog.setPublishdate("15-02-2021");
        newBlog.setLastupdatedate("24-08-2023");

        // Act
        blogService.addBlog(newBlog);
        List<Blog> blogs = blogService.getAllBlogs();

        // Assert
        assertEquals(3, blogs.size());
        assertTrue(blogs.stream().anyMatch(blog -> blog.getTitle().equals("New Blog")));
    }

    @Test
    public void testDeleteBlog() {
        // Arrange
        //int blogId = 2;
        int blogId = blogService.getAllBlogs().get(1).getId();

        // Act
        blogService.deleteblog(blogId);
        List<Blog> blogs = blogService.getAllBlogs();

        // Assert
        assertEquals(1, blogs.size());
        assertFalse(blogs.stream().anyMatch(blog -> blog.getId() == blogId));
    }

    @Test
    public void testUpdateBlog() {
        // Arrange
        //int blogId = 1;
        int blogId = blogService.getAllBlogs().get(0).getId();
        Blog updatedBlog = new Blog();
        updatedBlog.setTitle("Updated Blog");
        updatedBlog.setBody("This is the updated blog.");

        // Act
        blogService.updateblog(updatedBlog, blogId);
        Blog foundBlog = blogService.getBlogById(blogId);

        // Assert
        assertNotNull(foundBlog);
        assertEquals("Updated Blog", foundBlog.getTitle());
        assertEquals("This is the updated blog.", foundBlog.getBody());
    }

    @Test
    public void testIsBlogExistById_BlogExists() {
        // Arrange
        //int blogId = 1;
        int blogId = blogService.getAllBlogs().get(0).getId();

        // Act
        boolean exists = blogService.isBlogExistById(blogId);

        // Assert
        assertTrue(exists);
    }

    @Test
    public void testIsBlogExistById_BlogDoesNotExist() {
        // Arrange
        int blogId = 99;

        // Act
        boolean exists = blogService.isBlogExistById(blogId);

        // Assert
        assertFalse(exists);
    }
}
