package com.webboard.repository.mapper;

import com.webboard.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PostMapper {
    
    // 게시글 작성
    void insertPost(Post post);
    
    // 게시글 조회 (ID로)
    Post selectPostById(Integer postId);
    
    // 모든 게시글 조회 (페이징)
    List<Post> selectAllPosts(@Param("offset") int offset, @Param("limit") int limit);
    
    // 게시글 총 개수
    int selectPostCount();
    
    // 사용자별 게시글 조회
    List<Post> selectPostsByUserId(Integer userId);
    
    // 게시글 수정
    void updatePost(Post post);
    
    // 게시글 조회수 증가
    void incrementViews(Integer postId);
    
    // 게시글 삭제
    void deletePost(Integer postId);
}
