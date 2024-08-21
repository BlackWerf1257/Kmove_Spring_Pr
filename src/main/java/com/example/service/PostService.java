package com.example.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Entity.EntityPost;
import com.example.repository.RefoPost;

@Service
public class PostService {
    private final RefoPost postRepository;

    public PostService(RefoPost postRepository) {
        this.postRepository = postRepository;
    }

    public List<EntityPost> getAllPosts() {
        return postRepository.NativeGetAllPost();
    }
}
