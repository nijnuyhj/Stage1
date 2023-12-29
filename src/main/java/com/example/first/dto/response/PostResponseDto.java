package com.example.first.dto.response;

import com.example.first.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private String title;
    private String content;
    private String name;
    private String password;

    public PostResponseDto(Post post){
        this.title = post.getTitle();
        this.content = post.getContent();
        this.name = post.getName();
        this.password = post.getPassword();
    }
}
