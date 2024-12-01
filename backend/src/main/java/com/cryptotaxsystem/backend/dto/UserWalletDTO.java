package com.cryptotaxsystem.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWalletDTO {
    private String walletAddress;  // 지갑 주소
}
