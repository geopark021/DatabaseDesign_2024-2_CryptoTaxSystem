package com.cryptotaxsystem.backend.service;

import com.cryptotaxsystem.backend.dto.LoginDTO;
import com.cryptotaxsystem.backend.dto.SignupDTO;
import com.cryptotaxsystem.backend.entity.User;
import com.cryptotaxsystem.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 회원가입 처리
    public void signup(SignupDTO signupDTO) {
        // 이메일 중복 체크
        Optional<User> existingUser = userRepository.findByEmail(signupDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email is already taken");
        }

        // 새로운 User 객체 생성
        User user = new User();

        // DTO에서 정보를 가져와서 엔티티에 설정
        user.setEmail(signupDTO.getEmail());
        user.setPassword(signupDTO.getPassword());  // 평문 비밀번호 그대로 저장
        user.setNickname(signupDTO.getNickname());
        user.setJoinDate(java.time.LocalDateTime.now());

        // 사용자 저장
        userRepository.save(user);
    }


    // 로그인 처리
    public boolean login(LoginDTO loginDTO) {
        try {
            Optional<User> userOpt = userRepository.findByEmail(loginDTO.getEmail());

            if (userOpt.isPresent()) {
                User user = userOpt.get();
                String inputPassword = loginDTO.getPassword().trim();  // 입력 비밀번호의 앞뒤 공백 제거
                String storedPassword = user.getPassword().trim();  // 저장된 비밀번호의 앞뒤 공백 제거

                if (storedPassword.equals(inputPassword)) {
                    return true;  // 비밀번호 일치 시 로그인 성공
                } else {
                    System.out.println("Incorrect password for email: " + loginDTO.getEmail());
                    return false;  // 비밀번호 불일치
                }
            } else {
                System.out.println("User not found for email: " + loginDTO.getEmail());
                return false;  // 이메일 미존재
            }
        } catch (Exception e) {
            e.printStackTrace();  // 예외 메시지 출력
            return false;
        }
    }
}
