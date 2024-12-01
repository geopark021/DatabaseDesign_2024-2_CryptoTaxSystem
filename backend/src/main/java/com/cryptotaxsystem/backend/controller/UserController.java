package com.cryptotaxsystem.backend.controller;

import com.cryptotaxsystem.backend.dto.LoginDTO;
import com.cryptotaxsystem.backend.dto.SignupDTO;
import com.cryptotaxsystem.backend.entity.User;
import com.cryptotaxsystem.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 회원가입 처리 (POST /api/user/signup)
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupDTO signupDTO) {
        try {
            // 회원가입 로직: 비밀번호를 평문으로 처리
            userService.signup(signupDTO);
            return new ResponseEntity<>("User signed up successfully: " + signupDTO.getEmail(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error during signup: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // 로그인 처리 (POST /api/user/login)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        // 로그인 로직: 비밀번호를 평문으로 처리
        if (userService.login(loginDTO)) {
            return new ResponseEntity<>("Login successful: " + loginDTO.getEmail(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login failed. Please check your credentials.", HttpStatus.UNAUTHORIZED);
        }
    }
}
