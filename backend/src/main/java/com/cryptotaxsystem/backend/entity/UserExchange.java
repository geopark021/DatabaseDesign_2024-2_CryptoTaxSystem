package com.cryptotaxsystem.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@IdClass(UserExchangeId.class)
@Table(name = "userexchange")
public class UserExchange {

    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Id
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

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "exchange_id", insertable = false, updatable = false)
    private Exchange exchange;
}
