package com.cryptotaxsystem.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "wallettransaction")
@Getter
@Setter
@NoArgsConstructor
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wallet_tx_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    @OneToOne
    @JoinColumn(name = "coin_id", nullable = false)
    private Coin coin;

    @Column(name = "tx_hash", nullable = false, length = 66)
    private String txHash;

    @Column(name = "tx_type", length = 10)
    private String txType;

    @Column(name = "from_address", nullable = false, length = 255)
    private String fromAddress;

    @Column(name = "to_address", nullable = false, length = 255)
    private String toAddress;

    @Column(name = "coin_amount", nullable = false, precision = 35, scale = 18)
    private BigDecimal coinAmount;

    @Column(name = "tx_fee", nullable = false, precision = 35, scale = 18)
    private BigDecimal txFee;

    @Column(name = "block_number", nullable = false)
    private Long blockNumber;

    @Column(name = "tx_timestamp", nullable = false)
    private Long txTimestamp;
}
