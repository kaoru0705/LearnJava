package p1;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        {
            // 관리자가 회원 정보 목록을 원하는 경우
            List<User> list = new ArrayList<>();
        }

        {
            // 관리자가 모든 회원 정보와... 그 회원이 쓴 글의 모든 정보를 보고
            List<Map<String, Object>> totalDataList = new ArrayList<>();

            Map<String, Object> map1 = new HashMap<>();
            map1.put("userinfo", new User());
            List<Article> articleList = new ArrayList<>();
            articleList.add(new Article());
            articleList.add(new Article());
            articleList.add(new Article());
            map1.put("articleList", articleList);

            totalDataList.add(map1);
        }

        {
            // 글 상세 페이지
            // 글 정보 - 유저 정보
            //
            Map<String, Object> data = new HashMap<>();
            data.put("writer", new User());
            data.put("article", new Article());

            List<Map<String, Object>> commentDataList = new ArrayList<>();
            data.put("commentDataList", commentDataList);

            Map<String, Object> commentData1 = new HashMap<>();
            commentData1.put("comment", new Comment());
            commentData1.put("writer", new User());
            commentDataList.add(commentData1);
            
        }
    }
}

class User {
    String nickname;
    // 유저 정보
}

class Article {
    String title;
    String content;
    //...
}

class Comment {
    String text;
    //...
}