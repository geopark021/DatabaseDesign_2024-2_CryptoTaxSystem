package com.cryptotaxsystem.backend.controller;

import com.cryptotaxsystem.backend.dto.UserExchangeDTO;
import com.cryptotaxsystem.backend.service.UserExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exchange")
public class UserExchangeController {

    @Autowired
    private UserExchangeService userExchangeService;

    // 거래소 연결 처리 (POST /api/exchange/connect)
    @PostMapping("/connect")
    public String connectExchange(@RequestBody UserExchangeDTO userExchangeDTO) {
        userExchangeService.connectUserExchange(userExchangeDTO);
        return "Exchange connected successfully: " + userExchangeDTO.getApiName();
    }
}
