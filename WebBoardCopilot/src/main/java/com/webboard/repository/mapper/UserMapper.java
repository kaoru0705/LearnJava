package com.webboard.repository.mapper;

import com.webboard.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserMapper {
    
    // 회원 등록
    void insertUser(User user);
    
    // 사용자 조회 (ID로)
    User selectUserById(Integer userId);
    
    // 사용자 조회 (username으로)
    User selectUserByUsername(String username);
    
    // 모든 사용자 조회
    List<User> selectAllUsers();
    
    // 사용자 정보 수정
    void updateUser(User user);
    
    // 사용자 삭제
    void deleteUser(Integer userId);
}
