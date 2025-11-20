package com.webboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.webboard.repository.mapper")
public class WebBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebBoardApplication.class, args);
    }

}
