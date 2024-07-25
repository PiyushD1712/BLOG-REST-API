package com.example.Blog_Website.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false,length = 500)
    private String imgUrl;
    @Column(nullable = false)
    private String description;
    @CreatedDate
    private Date date;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
