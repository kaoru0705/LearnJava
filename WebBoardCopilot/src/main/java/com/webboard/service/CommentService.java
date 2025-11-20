package com.webboard.service;

import com.webboard.entity.Comment;
import com.webboard.repository.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {
    
    @Autowired
    private CommentMapper commentMapper;
    
    // 댓글 작성
    public void createComment(Comment comment) {
        commentMapper.insertComment(comment);
    }
    
    // 댓글 조회 (ID로)
    public Comment getCommentById(Integer commentId) {
        return commentMapper.selectCommentById(commentId);
    }
    
    // 게시글별 댓글 조회
    public List<Comment> getCommentsByPostId(Integer postId) {
        return commentMapper.selectCommentsByPostId(postId);
    }
    
    // 댓글 수정
    public void updateComment(Comment comment) {
        commentMapper.updateComment(comment);
    }
    
    // 댓글 삭제
    public void deleteComment(Integer commentId) {
        commentMapper.deleteComment(commentId);
    }
    
    // 게시글의 모든 댓글 삭제
    public void deleteCommentsByPostId(Integer postId) {
        commentMapper.deleteCommentsByPostId(postId);
    }
}
