package com.cryptotaxsystem.backend.service;

import com.cryptotaxsystem.backend.dto.UserExchangeDTO;
import org.springframework.stereotype.Service;

@Service
public class UserExchangeService {

    // 거래소 연결 처리
    public void connectUserExchange(UserExchangeDTO userExchangeDTO) {
        // 실제 API와 연결하여 거래소 정보를 처리하는 로직을 작성
        System.out.println("Connecting to exchange: " + userExchangeDTO.getApiName());
        // 예시로 API 키를 출력하는 것만 해놓음
    }
}
