package com.example.first.service;


import com.example.first.dto.request.PostRequestDto;
import com.example.first.dto.response.PostResponseDto;
import com.example.first.entity.Post;
import com.example.first.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
