package com.webboard.controller;

import com.webboard.entity.User;
import com.webboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/api")
public class ApiController {
    
    @Autowired
    private UserService userService;
    
    // 테스트 사용자 생성
    @GetMapping("/init-test-user")
    public String initTestUser(RedirectAttributes redirectAttributes) {
        try {
            // 기존 테스트 사용자 확인
            User existingUser = userService.getUserByUsername("testuser");
            if (existingUser != null) {
                redirectAttributes.addFlashAttribute("message", "테스트 사용자가 이미 존재합니다. (ID: testuser, PW: test1234)");
                return "redirect:/auth/login";
            }
            
            // 새 테스트 사용자 생성
            User testUser = User.builder()
                    .username("testuser")
                    .passwordHash("test1234")
                    .email("test@example.com")
                    .build();
            
            userService.registerUser(testUser);
            redirectAttributes.addFlashAttribute("message", "테스트 사용자가 생성되었습니다. (ID: testuser, PW: test1234)");
            return "redirect:/auth/login";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "테스트 사용자 생성 실패: " + e.getMessage());
            return "redirect:/auth/login";
        }
    }
    
    // 모든 사용자 조회 (디버깅용)
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "api/users";
    }
}
