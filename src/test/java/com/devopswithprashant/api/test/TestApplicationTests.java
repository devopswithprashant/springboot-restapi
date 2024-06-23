package com.devopswithprashant.api.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.devopswithprashant.api.test.dao.BlogRepository;
import com.devopswithprashant.api.test.entities.Blog;
import com.devopswithprashant.api.test.service.BlogService;

@SpringBootTest
class TestApplicationTests {

	@Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogService blogService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

	@Test
    public void testIsBlogExistById_BlogExists() {
        // Arrange
        int blogId = 3;
        when(blogRepository.isBlogExistById(blogId)).thenReturn(true);

        // Act
        boolean exists = blogService.isBlogExistById(blogId);

        // Assert
        assertTrue(exists);
    }



	@Test
    public void testGetBlogById_BlogExists() {
        // Arrange
        //Long blogId = 1L;
		Blog b1 = new Blog(2875, "git roadmap", "this is my content of git", "Verma, Shubham", "11-08-2023", "31-01-2024");
		// 	Blog b2 = new Blog(56535, "linux roadmap", "this is my content of linux", "Prajapati, Mohit", "11-05-2021", "01-01-2024");

        // Set other fields of the blog as needed
        when(blogRepository.findById(2875)).thenReturn(b1);

        // Act
        //Optional<Blog> foundBlog = Optional<Blog>(blogService.getBlogById(2875));
		Blog foundBlog = blogService.getBlogById(2875);

        // Assert
        assertNotNull(foundBlog);
        assertEquals(2875, foundBlog.getId());
        // Add other assertions as needed
    }


	@Test
    public void testGetBlogById_BlogDoesNotExist() {
    // Arrange
    int blogId = 100;
    when(blogRepository.findById(blogId)).thenReturn(null);

    // Act
    Blog foundBlog = blogService.getBlogById(blogId);

    // Assert        
	assertNull(foundBlog);
    }

	

	@Test
	public void getBlogTest() {

		Blog b1 = new Blog(20875, "git roadmap", "this is my content of git", "Verma, Shubham", "11-08-2023", "31-01-2024");
		Blog b2 = new Blog(50535, "linux roadmap", "this is my content of linux", "Prajapati, Mohit", "11-05-2021", "01-01-2024");
		
		when(blogRepository.findAll()).thenReturn(List.of(b1, b2));
		when(blogRepository.findById(20875)).thenReturn(b1);
		when(blogRepository.findById(50535)).thenReturn(b2);

		assertEquals(2, blogService.getAllBlogs().size());
		assertEquals("git roadmap", blogService.getBlogById(20875).getTitle());
		assertEquals("Prajapati, Mohit", blogService.getBlogById(50535).getAuthor());
		
	}


}
