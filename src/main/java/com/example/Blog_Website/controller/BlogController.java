package com.example.Blog_Website.controller;

import com.example.Blog_Website.dto.BlogDto;
import com.example.Blog_Website.model.Blog;
import com.example.Blog_Website.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService service;

    @PostMapping("/blog/add_blog")
    public String saveBlog(@RequestBody BlogDto blog){
        service.save(blog);
        return "Success";
    }

    @GetMapping({"/blog"})
    public List<Blog> showAllBlogs(){
        return service.findAll();
    }
}
