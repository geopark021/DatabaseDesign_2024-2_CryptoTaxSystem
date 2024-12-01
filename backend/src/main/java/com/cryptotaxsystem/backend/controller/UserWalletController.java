package com.cryptotaxsystem.backend.controller;

import com.cryptotaxsystem.backend.dto.UserWalletDTO;
import com.cryptotaxsystem.backend.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/wallet")
public class UserWalletController {

    @Autowired
    private UserWalletService userWalletService;

    @PostMapping("/save")
    public ResponseEntity<String> saveWallet(@RequestBody UserWalletDTO userWalletDTO) {
        try {
            String result = userWalletService.saveWallet(userWalletDTO);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving wallet information: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
