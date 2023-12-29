package com.example.first.dto.request;

import com.example.first.entity.Post;
import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String content;
    private String name;
    private String password;

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .name(name)
                .password(password)
                .build();
    }
}
