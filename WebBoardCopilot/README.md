# 웹 게시판 프로젝트

Spring Boot 3.x, MyBatis, Thymeleaf를 사용한 웹 게시판 애플리케이션입니다.

## 프로젝트 정보

- **Java**: 21
- **Spring Boot**: 3.3.4
- **Build Tool**: Gradle
- **Database**: MariaDB 11.4
- **Templating**: Thymeleaf
- **ORM**: MyBatis

## 기능

- 회원가입 및 로그인
- 게시글 CRUD (Create, Read, Update, Delete)
- 댓글 기능
- 게시글 조회수
- 페이징

## 프로젝트 구조

```
src/main/
├── java/com/webboard/
│   ├── WebBoardApplication.java
│   ├── controller/
│   │   ├── AuthController.java
│   │   ├── PostController.java
│   │   ├── CommentController.java
│   │   └── HomeController.java
│   ├── service/
│   │   ├── UserService.java
│   │   ├── PostService.java
│   │   └── CommentService.java
│   ├── entity/
│   │   ├── User.java
│   │   ├── Post.java
│   │   └── Comment.java
│   ├── repository/mapper/
│   │   ├── UserMapper.java
│   │   ├── PostMapper.java
│   │   └── CommentMapper.java
│   └── config/
│       └── SecurityConfig.java
├── resources/
│   ├── application.yml
│   ├── templates/
│   │   ├── auth/
│   │   │   ├── register.html
│   │   │   └── login.html
│   │   └── posts/
│   │       ├── list.html
│   │       ├── create.html
│   │       ├── view.html
│   │       └── edit.html
│   └── mapper/
│       ├── UserMapper.xml
│       ├── PostMapper.xml
│       └── CommentMapper.xml
```

## 데이터베이스 설정

### 1단계: 데이터베이스 및 테이블 생성

**MariaDB 명령 프롬프트에서 다음을 실행합니다:**

```bash
mysql -u root -p < init-database.sql
```

또는 MariaDB 클라이언트에서 직접 실행:

```sql
-- test 데이터베이스 생성
CREATE DATABASE test CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE test;

-- 아래 테이블 생성 SQL 실행 (init-database.sql 참조)
```

```sql
CREATE TABLE users (
    user_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '사용자 고유 ID',
    username VARCHAR(50) NOT NULL UNIQUE COMMENT '사용자 이름 (로그인 ID로 사용)',
    password_hash VARCHAR(255) NOT NULL COMMENT '비밀번호 해시 값',
    email VARCHAR(100) UNIQUE COMMENT '이메일 주소 (선택 사항, UNIQUE)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '가입일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='게시판 사용자 정보';

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
```

## 설정

`application.yml` 파일에서 데이터베이스 연결 정보를 설정합니다:

```yaml
spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/test
    username: test
    password: '!@test1234'
```

## 빌드 및 실행

### 빌드

```bash
./gradlew build
```

### 실행

```bash
./gradlew bootRun
```

또는

```bash
java -jar build/libs/web-board-1.0.0.jar
```

## 접속

- 주소: `http://localhost:8080`
- 회원가입: `/auth/register`
- 로그인: `/auth/login`
- 게시판: `/posts`

## API 엔드포인트

### 인증
- `GET /auth/register` - 회원가입 페이지
- `POST /auth/register` - 회원가입 처리
- `GET /auth/login` - 로그인 페이지
- `POST /auth/login` - 로그인 처리
- `GET /auth/logout` - 로그아웃

### 게시글
- `GET /posts` - 게시글 목록
- `GET /posts/{id}` - 게시글 상세 조회
- `GET /posts/create` - 게시글 작성 페이지
- `POST /posts/create` - 게시글 작성
- `GET /posts/{id}/edit` - 게시글 수정 페이지
- `POST /posts/{id}/edit` - 게시글 수정
- `GET /posts/{id}/delete` - 게시글 삭제

### 댓글
- `POST /comments/create` - 댓글 작성
- `POST /comments/{id}/edit` - 댓글 수정
- `GET /comments/{id}/delete` - 댓글 삭제

## 기술 스택

- **Backend**: Spring Boot 3.x
- **Database**: MariaDB 11.4
- **Frontend**: Thymeleaf, HTML5, CSS3
- **ORM**: MyBatis
- **Build Tool**: Gradle
- **Security**: Spring Security, BCrypt

## 라이선스

MIT License
