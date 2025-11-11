package com.webboard.service;

import com.webboard.entity.User;
import com.webboard.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    // 회원 등록
    public void registerUser(User user) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        userMapper.insertUser(user);
    }
    
    // 회원 조회 (ID로)
    public User getUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }
    
    // 회원 조회 (username으로)
    public User getUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
    
    // 모든 회원 조회
    public List<User> getAllUsers() {
        return userMapper.selectAllUsers();
    }
    
    // 회원 정보 수정
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
    
    // 회원 삭제
    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }
    
    // 로그인 검증
    public boolean validateLogin(String username, String password) {
        User user = userMapper.selectUserByUsername(username);
        if (user == null) {
            return false;
        }
        return passwordEncoder.matches(password, user.getPasswordHash());
    }
}
