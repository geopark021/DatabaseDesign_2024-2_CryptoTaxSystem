package com.cryptotaxsystem.backend.service;

import com.cryptotaxsystem.backend.dto.UserWalletDTO;
import org.springframework.stereotype.Service;

@Service
public class UserWalletService {

    // 지갑 연결 처리
    public void connectUserWallet(UserWalletDTO userWalletDTO) {
        // 실제 MetaMask Extension과 연결하여 지갑 주소를 처리하는 로직
        System.out.println("Connecting to wallet: " + userWalletDTO.getWalletAddress());
        // 예시로 지갑 주소만 출력
    }
}
