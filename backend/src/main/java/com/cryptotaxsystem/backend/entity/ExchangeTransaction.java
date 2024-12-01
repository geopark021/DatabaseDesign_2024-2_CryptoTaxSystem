package com.cryptotaxsystem.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "exchangetransaction")
@Getter
@Setter
@NoArgsConstructor
public class ExchangeTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exchange_tx_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "exchange_id", nullable = false)
    private Exchange exchange;

    @OneToOne
    @JoinColumn(name = "coin_id", nullable = false)
    private Coin coin;

    @Column(name = "tx_type", length = 10)
    private String txType;

    @Column(name = "execution_timestamp", nullable = false)
    private Long executionTimestamp;

    @Column(name = "execution_price", nullable = false, precision = 35, scale = 18)
    private BigDecimal executionPrice;

    @Column(name = "coin_amount", nullable = false, precision = 35, scale = 18)
    private BigDecimal coinAmount;

    @Column(name = "trade_amount", nullable = false, precision = 35, scale = 18)
    private BigDecimal tradeAmount;

    @Column(name = "trade_fee", nullable = false, precision = 35, scale = 18)
    private BigDecimal tradeFee;

    @Column(name = "acquisition_cost", nullable = false, precision = 35, scale = 18)
    private BigDecimal acquisitionCost;

    @Column(name = "currency_code", nullable = false, length = 10)
    private String currencyCode;

    @Column(name = "external_trade_id", length = 255)
    private String externalTradeId;

    @Column(name = "memo")
    private String memo;

    @Column(name = "coin_price_usd", nullable = false, precision = 18, scale = 8)
    private BigDecimal coinPriceUsd;

    @Column(name = "coin_price_krw", nullable = false, precision = 20, scale = 2)
    private BigDecimal coinPriceKrw;
}
