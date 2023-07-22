package com.oburnett127.socialmedia.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import com.oburnett127.socialmedia.model.Post;
import com.oburnett127.socialmedia.repository.PostRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @SneakyThrows
    public Post getOnePost(int postId) {
        final Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()) return post.get();
        else return null;
    }

    @SneakyThrows
    public List<Post> getPostsByUserId(int userId) {
        return postRepository.findByUserId(userId);
    }

    @SneakyThrows
    public void createPost(Post post) {
        postRepository.save(post);   
    }
}