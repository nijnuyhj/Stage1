package com.example.first.controller;

import com.example.first.dto.request.PostRequestDto;
import com.example.first.dto.response.PostResponseDto;
import com.example.first.dto.response.ResponseMessageDto;
import com.example.first.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<ResponseMessageDto<PostResponseDto>> createPost(@RequestBody PostRequestDto postRequestDto){
        PostResponseDto response = postService.createPost(postRequestDto);
        return new ResponseEntity<>(new ResponseMessageDto<>("게시글 작성 성공",response),HttpStatus.CREATED);
    }

    @GetMapping("/posts")
    public ResponseEntity<ResponseMessageDto<List<PostResponseDto>>>getPostList(){
        List<PostResponseDto> response = postService.getPostList();
        return new ResponseEntity<>(new ResponseMessageDto<>("게시글 전체 조회 성공",response),HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<ResponseMessageDto<PostResponseDto>>getPost(@PathVariable Long postId){
        PostResponseDto response = postService.getPost(postId);
        return new ResponseEntity<>(new ResponseMessageDto<>("게시글 조회 성공",response),HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<ResponseMessageDto<PostResponseDto>>updatePost(@PathVariable Long postId, @RequestBody PostRequestDto postRequestDto){
        PostResponseDto response = postService.updatePost(postId,postRequestDto);
        return new ResponseEntity<>(new ResponseMessageDto<>("게시글 수정 성공",response),HttpStatus.ACCEPTED);
    }

}
