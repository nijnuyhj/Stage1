package com.example.first.service;


import com.example.first.dto.request.PostRequestDto;
import com.example.first.dto.response.PostResponseDto;
import com.example.first.entity.Post;
import com.example.first.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto createPost(PostRequestDto postRequestDto){
        Post post = postRequestDto.toEntity();
        postRepository.save(post);
        return new PostResponseDto(post);
    }

    @Transactional
    public List<PostResponseDto> getPostList(){
        List<PostResponseDto> getPostList =postRepository.getPostList();
        return getPostList;
    }

    @Transactional
    public PostResponseDto getPost(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long postId, PostRequestDto postRequestDto){
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        post.updatePost(postRequestDto.getTitle(),postRequestDto.getContent(),postRequestDto.getName(),postRequestDto.getPassword());
        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto deletePost(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        postRepository.deleteById(postId);
        return new PostResponseDto(post);
    }
}
