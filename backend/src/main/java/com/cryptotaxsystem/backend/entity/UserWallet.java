package com.cryptotaxsystem.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "userwallet")
public class UserWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userwal_id")
    private Integer userwalId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "wallet_id")
    private Integer walletId;

    @Column(name = "wallet_address", length = 50)
    private String walletAddress;

    @Column(name = "address_nickname", length = 50)
    private String addressNickname;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;  // LocalDateTime으로 변경
}
