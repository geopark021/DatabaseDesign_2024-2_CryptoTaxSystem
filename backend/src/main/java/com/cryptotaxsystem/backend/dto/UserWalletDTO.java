package com.cryptotaxsystem.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserWalletDTO {

    private Integer userId;
    private Integer walletId;
    private String walletAddress;
    private String addressNickname;
    private LocalDateTime registeredAt;  // LocalDateTime으로 변경
}
