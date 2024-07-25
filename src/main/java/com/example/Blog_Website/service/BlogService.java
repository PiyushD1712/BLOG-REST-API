package com.example.Blog_Website.service;

import com.example.Blog_Website.dto.BlogDto;
import com.example.Blog_Website.model.Blog;
import com.example.Blog_Website.model.User;
import com.example.Blog_Website.repository.BlogRepo;
import com.example.Blog_Website.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepo repo;
    @Autowired
    private UserService userService;

    private CustomUserDetails userDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (CustomUserDetails) authentication.getPrincipal();
    }

    public void save(BlogDto blogDto){
        User user = userService.findUser(userDetails().getId());
        Blog blog = new Blog();
        blog.setTitle(blogDto.getTitle());
        blog.setImgUrl(blogDto.getImgUrl());
        blog.setDescription(blogDto.getDescription());
        blog.setUser(user);
        repo.save(blog);
    }
    public List<Blog> findAll(){
        return repo.findAll();
    }
}
