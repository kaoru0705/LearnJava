-- 웹 게시판 데이터베이스 초기화 스크립트

-- test 데이터베이스 생성 (이미 존재하면 스킵)
-- CREATE DATABASE test CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE test;

-- 기존 테이블 삭제 (순서 중요: 외래키 참조 순서)
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS users;

-- users 테이블 생성
CREATE TABLE users (
    user_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '사용자 고유 ID',
    username VARCHAR(50) NOT NULL UNIQUE COMMENT '사용자 이름 (로그인 ID로 사용)',
    password_hash VARCHAR(255) NOT NULL COMMENT '비밀번호 해시 값',
    email VARCHAR(100) UNIQUE COMMENT '이메일 주소 (선택 사항, UNIQUE)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '가입일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='게시판 사용자 정보';

-- posts 테이블 생성
CREATE TABLE posts (
    post_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '게시글 고유 ID',
    user_id INT UNSIGNED NOT NULL COMMENT '작성자 ID (users.user_id 참조)',
    title VARCHAR(255) NOT NULL COMMENT '게시글 제목',
    content TEXT NOT NULL COMMENT '게시글 내용',
    views INT UNSIGNED DEFAULT 0 COMMENT '조회수',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '작성일시',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '최종 수정일시',
    FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='게시글 정보';

-- comments 테이블 생성
CREATE TABLE comments (
    comment_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '댓글 고유 ID',
    post_id INT UNSIGNED NOT NULL COMMENT '댓글이 달린 게시글 ID (posts.post_id 참조)',
    user_id INT UNSIGNED NOT NULL COMMENT '댓글 작성자 ID (users.user_id 참조)',
    content VARCHAR(1000) NOT NULL COMMENT '댓글 내용',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '작성일시',
    FOREIGN KEY (post_id)
        REFERENCES posts(post_id)
        ON DELETE CASCADE,
    FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='게시글 댓글 정보';

-- 테스트 데이터 삽입
-- 사용자: testuser (비밀번호: test1234 - 해시화됨)
-- BCrypt로 "test1234"를 암호화한 값
INSERT INTO users (username, password_hash, email) VALUES 
('testuser', '$2a$10$fV8DQDZKCk/BoKX65ZSyIemhIpBH8JnvpqsQBOyZBP9JVVRgZJiJm', 'test@example.com');

SELECT '✅ 데이터베이스 초기화 완료!' AS 'Result';
SELECT * FROM users;
