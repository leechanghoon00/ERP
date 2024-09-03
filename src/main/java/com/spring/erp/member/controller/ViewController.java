package com.spring.erp.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/login") //로그인 창 띄우기
    public String login() {
        return "login"; // login.html을 반환합니다.
    }

    @GetMapping("/main") //메인 창 띄우기
    public String main() {
        return "main"; // main.html을 반환합니다.
    }
}
