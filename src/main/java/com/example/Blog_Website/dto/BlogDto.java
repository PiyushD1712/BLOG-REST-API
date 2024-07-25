package com.example.Blog_Website.dto;

import com.example.Blog_Website.model.User;
import lombok.Data;

@Data
public class BlogDto {
    private Long id;
    private String title;
    private String imgUrl;
    private String description;
    private User author;
}
