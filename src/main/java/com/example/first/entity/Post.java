package com.example.first.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String content;

    @Builder
    public Post(String title, String content, String name, String password){
        this.title = title;
        this.content = content;
        this.name = name;
        this.password = password;

    }

    public void updatePost(String title, String content, String name, String password){
        this.title = title;
        this.content = content;
        this.name = name;
        this.password = password;
    }

}
