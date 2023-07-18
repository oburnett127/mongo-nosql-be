package com.oburnett127.socialmedia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.oburnett127.socialmedia.model.Post;
import com.oburnett127.socialmedia.model.dto.PostDto;
import com.oburnett127.socialmedia.model.request.PostCreateRequest;
import com.oburnett127.socialmedia.service.PostService;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/getonepost/{postId}")
    public ResponseEntity<PostDto> getOnePost(@Validated @PathVariable int postId) {
        System.out.println("inside getOnePost() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final var post = service.getOnePost(postId);
        var result = new PostDto(postId, post.getUserId(), post.getText());
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getbyjobid/{jobId}")
    public ResponseEntity<PostDto[]> getPostsByUserId(@Validated @PathVariable String userId) {
        System.out.println("inside getPostByUserId() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        List<Post> posts = service.getPostsByUserId(Integer.parseInt(userId));

        var result = posts.stream()
                    .map(post -> new PostDto(post.getPostId(), post.getUserId(), post.getText()))
                    .collect(Collectors.toList());

        PostDto[] postArray = result.toArray(new PostDto[0]);                    

        return new ResponseEntity<>(postArray, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@Validated @RequestBody PostCreateRequest postCreateRequest ) throws IOException {
        System.out.println("inside createPost() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        service.createPost(postCreateRequest);
        return ResponseEntity.ok().body(null);
    }
}