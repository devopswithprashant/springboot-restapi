package com.devopswithprashant.api.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devopswithprashant.api.test.dao.BlogRepository;

@SpringBootTest
public class BlogRepositoryTest {

    @Autowired
    private BlogRepository blogRepository;

    @Test
    void isBlogExistbyIdTest() {
        assertTrue(blogRepository.isBlogExistById(3));
        assertFalse(blogRepository.isBlogExistById(45));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down");
    }

    @BeforeEach
    void setup() {
        System.out.println("Setting up");
    }
}
