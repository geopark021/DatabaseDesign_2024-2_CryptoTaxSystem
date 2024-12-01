package com.cryptotaxsystem.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExchangeDTO {
    private String apiName;
    private String apiKey;
    private String apiSecretKey;
    private Integer exchangeId;  // 거래소 ID
}
