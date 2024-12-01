package com.cryptotaxsystem.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tax")
@Getter
@Setter
@NoArgsConstructor
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "wallet_tx_id")
    private WalletTransaction walletTransaction;

    @ManyToOne
    @JoinColumn(name = "exchange_tx_id")
    private ExchangeTransaction exchangeTransaction;

    @Column(name = "tx_src_type", length = 20)
    private String txSrcType;

    @Column(name = "tax_payment_due_date")
    private LocalDateTime taxPaymentDueDate;

    @Column(name = "acquisition_cost", precision = 35, scale = 18)
    private BigDecimal acquisitionCost;

    @Column(name = "calculated_tax", precision = 20, scale = 2)
    private BigDecimal calculatedTax;
}
