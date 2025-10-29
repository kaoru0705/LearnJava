package com.joongang.stm.controller;

import com.joongang.stm.service.Service;

// 현재: 전체 흐름을 담당한다.
// 나중에 스프링에서는 사용자 입출력 담당 (최전방)
public class Controller {
    
    private Service service = new Service();    // composition

    public void run() {
        service.welcome();
        service.add();
        service.bye();
    }

}