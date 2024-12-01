package com.cryptotaxsystem.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserExchangeDTO {
    private String apiKey;  // API 키
    private String secretKey;  // 비밀키
    private String apiName;  // 거래소 이름 (여기서는 바이낸스)
}
