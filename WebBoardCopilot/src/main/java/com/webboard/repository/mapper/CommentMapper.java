package com.webboard.repository.mapper;

import com.webboard.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CommentMapper {
    
    // 댓글 작성
    void insertComment(Comment comment);
    
    // 댓글 조회 (ID로)
    Comment selectCommentById(Integer commentId);
    
    // 게시글별 댓글 조회
    List<Comment> selectCommentsByPostId(Integer postId);
    
    // 댓글 수정
    void updateComment(Comment comment);
    
    // 댓글 삭제
    void deleteComment(Integer commentId);
    
    // 게시글의 모든 댓글 삭제
    void deleteCommentsByPostId(Integer postId);
}
