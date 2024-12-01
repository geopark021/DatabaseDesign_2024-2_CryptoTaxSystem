package com.cryptotaxsystem.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@IdClass(UserWalletId.class)
@Table(name = "userwallet", uniqueConstraints = {
        @UniqueConstraint(name = "idx_wallet_address", columnNames = "wallet_address")
})
public class UserWallet {

    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Id
    @Column(name = "wallet_id", nullable = false)
    private Integer walletId;

    @Column(name = "wallet_address", nullable = false, length = 50)
    private String walletAddress;

    @Column(name = "address_nickname", length = 50)
    private String addressNickname;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "wallet_id", insertable = false, updatable = false)
    private Wallet wallet;
}
