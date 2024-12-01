package com.cryptotaxsystem.backend.controller;

import com.cryptotaxsystem.backend.dto.UserExchangeDTO;
import com.cryptotaxsystem.backend.service.UserExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/exchange")
public class UserExchangeController {

    @Autowired
    private UserExchangeService userExchangeService;

    // 거래소 등록 처리 (POST /api/user/exchange/save)
    @PostMapping("/save")
    public ResponseEntity<String> saveExchange(@RequestBody UserExchangeDTO userExchangeDTO,
                                               @RequestParam String email) {
        try {
            String result = userExchangeService.registerExchange(userExchangeDTO, email);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving exchange information: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
