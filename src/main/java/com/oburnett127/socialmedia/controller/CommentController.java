package com.oburnett127.socialmedia.controller;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.oburnett127.socialmedia.model.Comment;
import com.oburnett127.socialmedia.model.request.CommentCreateRequest;
import com.oburnett127.socialmedia.service.CommentService;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping("/getbypost/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@Validated @PathVariable ObjectId postId) {
        System.out.println("inside CommentController.getCommentsByPostId() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final List<Comment> comments = service.getCommentsByPostId(postId);
        return ResponseEntity.ok().body(comments);
    }

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@Validated @RequestBody CommentCreateRequest commentCreateRequest) throws IOException {
        System.out.println("inside CommentController.createComment() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final Comment comment = Comment.builder()
                .postId(commentCreateRequest.getPostId())
                .userId(commentCreateRequest.getUserId())
                .text(commentCreateRequest.getText())
                .build();
        service.createComment(comment);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/delete/{commentId}")
    public ResponseEntity<Comment> deleteComment(@Validated @PathVariable ObjectId commentId) throws IOException {
        System.out.println("inside CommentController.deleteComment() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        service.deleteComment(commentId);
        return ResponseEntity.ok().body(null);
    }
}