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
public class Comment {
    private Integer commentId;
    private Integer postId;
    private Integer userId;
    private String content;
    private LocalDateTime createdAt;
    
    // 조회용 필드 (username 포함)
    private String username;
}
