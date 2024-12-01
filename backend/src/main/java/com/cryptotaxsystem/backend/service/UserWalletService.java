package com.cryptotaxsystem.backend.service;

import com.cryptotaxsystem.backend.dto.UserWalletDTO;
import com.cryptotaxsystem.backend.entity.UserWallet;
import com.cryptotaxsystem.backend.repository.UserWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserWalletService {

    @Autowired
    private UserWalletRepository userWalletRepository;

    public String saveWallet(UserWalletDTO userWalletDTO) {
        UserWallet userWallet = new UserWallet();
        userWallet.setUserId(userWalletDTO.getUserId());
        userWallet.setWalletId(userWalletDTO.getWalletId());
        userWallet.setWalletAddress(userWalletDTO.getWalletAddress());
        userWallet.setAddressNickname(userWalletDTO.getAddressNickname());
        userWallet.setRegisteredAt(LocalDateTime.now());  // 현재 시간 설정

        userWalletRepository.save(userWallet);

        return "Wallet information saved successfully.";
    }
}
