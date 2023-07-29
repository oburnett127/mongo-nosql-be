package com.oburnett127.socialmedia.service;

import lombok.SneakyThrows;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import com.oburnett127.socialmedia.model.Comment;
import com.oburnett127.socialmedia.repository.CommentRepository;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @SneakyThrows
    public List<Comment> getCommentsByPostId(ObjectId postId) {
        return commentRepository.findByPostId(postId);
    }

    @SneakyThrows
    public void createComment(Comment comment) {
        commentRepository.save(comment);   
    }

    @SneakyThrows
    public void deleteComment(ObjectId commentId) {
        commentRepository.deleteById(commentId);
    }
}