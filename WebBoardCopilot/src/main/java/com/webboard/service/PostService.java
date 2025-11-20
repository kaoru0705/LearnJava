package com.webboard.service;

import com.webboard.entity.Post;
import com.webboard.repository.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {
    
    @Autowired
    private PostMapper postMapper;
    
    // 게시글 작성
    public void createPost(Post post) {
        postMapper.insertPost(post);
    }
    
    // 게시글 조회 (ID로)
    public Post getPostById(Integer postId) {
        // 조회수 증가
        postMapper.incrementViews(postId);
        return postMapper.selectPostById(postId);
    }
    
    // 모든 게시글 조회 (페이징)
    public List<Post> getAllPosts(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return postMapper.selectAllPosts(offset, pageSize);
    }
    
    // 게시글 총 개수
    public int getPostCount() {
        return postMapper.selectPostCount();
    }
    
    // 사용자별 게시글 조회
    public List<Post> getPostsByUserId(Integer userId) {
        return postMapper.selectPostsByUserId(userId);
    }
    
    // 게시글 수정
    public void updatePost(Post post) {
        postMapper.updatePost(post);
    }
    
    // 게시글 삭제
    public void deletePost(Integer postId) {
        postMapper.deletePost(postId);
    }
}
