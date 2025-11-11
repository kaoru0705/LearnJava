# 웹 게시판 프로젝트 - 개발 가이드

## 프로젝트 개요

Spring Boot 3.x, MyBatis, Thymeleaf를 기반으로 한 웹 게시판 애플리케이션

- **Java**: 21
- **Spring Boot**: 3.3.4
- **Database**: MariaDB 11.4
- **Build Tool**: Gradle

## 프로젝트 구조

```
WebBoardCopilot/
├── build.gradle           # Gradle 빌드 설정
├── settings.gradle        # 프로젝트 이름 설정
├── README.md             # 프로젝트 문서
├── .gitignore            # Git 무시 파일
└── src/
    └── main/
        ├── java/com/webboard/
        │   ├── WebBoardApplication.java     # 메인 애플리케이션 클래스
        │   ├── controller/                  # 컨트롤러 (요청 처리)
        │   ├── service/                     # 비즈니스 로직 서비스
        │   ├── entity/                      # 도메인 모델
        │   ├── repository/mapper/           # MyBatis 매퍼 인터페이스
        │   └── config/                      # 설정 클래스
        └── resources/
            ├── application.yml              # Spring Boot 설정
            ├── templates/                   # Thymeleaf 템플릿
            │   ├── auth/                   # 인증 관련 HTML
            │   └── posts/                  # 게시글 관련 HTML
            └── mapper/                      # MyBatis XML 매퍼
```

## 사전 요구사항

1. **Java 21 설치**: JDK 21 이상
2. **Gradle**: 프로젝트에 Gradle Wrapper 포함
3. **MariaDB 11.4**: 데이터베이스 설치 및 실행
4. **Database 생성**: `test` 데이터베이스 생성

## 초기 설정

### 1. 데이터베이스 설정

MariaDB에 접속하여 다음 명령 실행:

```sql
-- test 데이터베이스 생성
CREATE DATABASE test CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 테이블 생성 (README.md 참조)
```

### 2. 애플리케이션 설정

`src/main/resources/application.yml`에서 데이터베이스 연결 정보 확인:

```yaml
spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/test
    username: test
    password: '!@test1234'
```

### 3. 프로젝트 빌드

```bash
./gradlew clean build
```

## 실행

### 개발 모드 실행

```bash
./gradlew bootRun
```

### JAR 파일로 실행

```bash
./gradlew build
java -jar build/libs/web-board-1.0.0.jar
```

### 접속 정보

- 기본 URL: `http://localhost:8080`
- 게시판 페이지: `http://localhost:8080/posts`

## 주요 기능

### 1. 인증 시스템
- **회원가입** (`/auth/register`)
  - 사용자명, 이메일, 비밀번호로 계정 생성
  - BCrypt 해시로 비밀번호 암호화

- **로그인** (`/auth/login`)
  - 사용자명과 비밀번호로 로그인
  - 세션에 사용자 정보 저장

- **로그아웃** (`/auth/logout`)
  - 세션 무효화

### 2. 게시글 관리
- **목록 조회** (`/posts`)
  - 페이징 (페이지당 10개)
  - 작성자, 조회수, 작성일 표시

- **상세 조회** (`/posts/{id}`)
  - 조회수 자동 증가
  - 댓글 표시

- **작성** (`/posts/create`)
  - 로그인 필수
  - 제목, 내용 입력

- **수정** (`/posts/{id}/edit`)
  - 작성자만 가능

- **삭제** (`/posts/{id}/delete`)
  - 작성자만 가능

### 3. 댓글 관리
- **작성** (`/comments/create`)
  - 로그인 필수
  - 게시글별로 관리

- **수정** (`/comments/{id}/edit`)
  - 작성자만 가능

- **삭제** (`/comments/{id}/delete`)
  - 작성자만 가능

## 주요 클래스

### Entity (엔티티)
- `User.java`: 사용자 정보
- `Post.java`: 게시글 정보
- `Comment.java`: 댓글 정보

### Mapper (MyBatis)
- `UserMapper.java`: 사용자 데이터 접근
- `PostMapper.java`: 게시글 데이터 접근
- `CommentMapper.java`: 댓글 데이터 접근

### Service (비즈니스 로직)
- `UserService.java`: 사용자 관리 로직
- `PostService.java`: 게시글 관리 로직
- `CommentService.java`: 댓글 관리 로직

### Controller (요청 처리)
- `AuthController.java`: 인증 요청 처리
- `PostController.java`: 게시글 요청 처리
- `CommentController.java`: 댓글 요청 처리
- `HomeController.java`: 홈 페이지 리다이렉트

## 추가 개발 가이드

### 새 기능 추가

1. **Entity 정의**: `entity/` 디렉토리에 새 클래스 추가
2. **Mapper 인터페이스**: `repository/mapper/` 디렉토리에 인터페이스 추가
3. **XML 매퍼**: `resources/mapper/` 디렉토리에 XML 파일 추가
4. **Service 클래스**: `service/` 디렉토리에 비즈니스 로직 추가
5. **Controller**: `controller/` 디렉토리에 엔드포인트 추가
6. **Template**: `resources/templates/` 디렉토리에 HTML 추가

### 로깅 레벨 설정

`application.yml`에서 로깅 레벨 조정:

```yaml
logging:
  level:
    com.webboard: DEBUG    # 애플리케이션 로그
    org.mybatis: DEBUG     # MyBatis 로그
```

### 포트 변경

`application.yml`에서 포트 변경:

```yaml
server:
  port: 8080  # 원하는 포트로 변경
```

## 문제 해결

### 데이터베이스 연결 실패
- MariaDB 서비스 실행 여부 확인
- `application.yml`의 연결 정보 확인
- 데이터베이스 `test` 존재 여부 확인

### 컴파일 에러
```bash
./gradlew clean build --refresh-dependencies
```

### 포트 충돌
- 8080 포트 사용 중인 프로세스 확인
- `application.yml`에서 다른 포트로 변경

## 참고 자료

- [Spring Boot 공식 문서](https://spring.io/projects/spring-boot)
- [MyBatis 공식 문서](https://mybatis.org/)
- [Thymeleaf 공식 문서](https://www.thymeleaf.org/)
- [Gradle 공식 문서](https://gradle.org/)

## 라이선스

MIT License
