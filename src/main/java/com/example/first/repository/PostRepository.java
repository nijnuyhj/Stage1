package com.example.first.repository;

import com.example.first.dto.response.PostResponseDto;
import com.example.first.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("SELECT new com.example.first.dto.response.PostResponseDto(p.id, p.title, p.name, p.password, p.content) FROM Post p")
    List<PostResponseDto> getPostList();


}
