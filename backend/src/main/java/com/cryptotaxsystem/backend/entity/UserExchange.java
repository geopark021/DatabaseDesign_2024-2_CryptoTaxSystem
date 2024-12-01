package com.cryptotaxsystem.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "userexchange")
public class UserExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userex_id")
    private Integer userexId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "exchange_id", nullable = false)
    private Integer exchangeId;

    @Column(name = "api_name", length = 50)
    private String apiName;

    @Column(name = "api_key", length = 255)
    private String apiKey;

    @Column(name = "api_secret_key", length = 255)
    private String apiSecretKey;

    @Column(name = "api_registered_at")
    private LocalDateTime apiRegisteredAt;

    // userId에 대한 setter 메소드 추가
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    // exchangeId에 대한 setter 메소드 추가
    public void setExchangeId(Integer exchangeId) {
        this.exchangeId = exchangeId;
    }
}
