package com.cryptotaxsystem.backend.controller;

import com.cryptotaxsystem.backend.dto.UserWalletDTO;
import com.cryptotaxsystem.backend.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
public class UserWalletController {

    @Autowired
    private UserWalletService userWalletService;

    // 지갑 연결 처리 (POST /api/wallet/connect)
    @PostMapping("/connect")
    public String connectWallet(@RequestBody UserWalletDTO userWalletDTO) {
        userWalletService.connectUserWallet(userWalletDTO);
        return "Wallet connected successfully: " + userWalletDTO.getWalletAddress();
    }
}
