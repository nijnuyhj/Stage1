package com.example.first.controller;

import com.example.first.dto.request.PostRequestDto;
import com.example.first.dto.response.PostResponseDto;
import com.example.first.dto.response.ResponseMessageDto;
import com.example.first.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<ResponseMessageDto<PostResponseDto>> createPost(@RequestBody PostRequestDto postRequestDto){
        postService.createPost(postRequestDto);
        return new ResponseEntity<>(new ResponseMessageDto<>("게시글 작성 성공",null),HttpStatus.CREATED);
    }

}
