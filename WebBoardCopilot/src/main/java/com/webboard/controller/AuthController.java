package com.webboard.controller;

import com.webboard.entity.User;
import com.webboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    // 회원가입 페이지
    @GetMapping("/register")
    public String registerPage() {
        return "auth/register";
    }
    
    // 회원가입 처리
    @PostMapping("/register")
    public String register(@RequestParam String username, 
                          @RequestParam String password,
                          @RequestParam(required = false) String email,
                          RedirectAttributes redirectAttributes) {
        try {
            // 사용자명 중복 체크
            User existingUser = userService.getUserByUsername(username);
            if (existingUser != null) {
                redirectAttributes.addFlashAttribute("error", "이미 사용 중인 사용자명입니다.");
                return "redirect:/auth/register";
            }
            
            User user = User.builder()
                    .username(username)
                    .passwordHash(password)
                    .email(email)
                    .build();
            userService.registerUser(user);
            redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다. 로그인해주세요.");
            return "redirect:/auth/login";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "회원가입 실패: " + e.getMessage());
            return "redirect:/auth/register";
        }
    }
    
    // 로그인 페이지
    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }
    
    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam String username,
                       @RequestParam String password,
                       HttpSession session,
                       RedirectAttributes redirectAttributes) {
        if (userService.validateLogin(username, password)) {
            User user = userService.getUserByUsername(username);
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "redirect:/auth/login";
        }
    }
    
    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
