package com.webboard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    private Integer postId;
    private Integer userId;
    private String title;
    private String content;
    private Integer views;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // 조회용 필드 (username 포함)
    private String username;
}
