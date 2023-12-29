package com.example.first.dto.response;

import com.example.first.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String name;
    private String password;

    public PostResponseDto(Long id, String title, String content, String name, String password) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.name = name;
        this.password = password;
    }

    public PostResponseDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.name = post.getName();
        this.password = post.getPassword();
    }
}
