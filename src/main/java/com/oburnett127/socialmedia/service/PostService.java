package com.oburnett127.socialmedia.service;

import lombok.SneakyThrows;

import org.bson.types.ObjectId;
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
    public Post getOnePost(ObjectId postId) {
        final Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()) return post.get();
        else return null;
    }

    @SneakyThrows
    public List<Post> getPostsByAuthorUserId(ObjectId authorUserId) {
        return postRepository.findByAuthorUserId(authorUserId);
    }

    @SneakyThrows
    public List<Post> getPostsByProfileUserId(ObjectId profileUserId) {
        return postRepository.findByProfileUserId(profileUserId);
    }

    @SneakyThrows
    public void createPost(Post post) {
        postRepository.save(post);   
    }
}