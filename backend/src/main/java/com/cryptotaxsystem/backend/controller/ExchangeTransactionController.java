package com.cryptotaxsystem.backend.controller;

import com.cryptotaxsystem.backend.entity.Tax;
import com.cryptotaxsystem.backend.service.ExchangeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/exchangetransactions")
public class ExchangeTransactionController {

    @Autowired
    private ExchangeTransactionService exchangeTransactionService;

    // 매도 거래에 대해 세금 계산 (ExchangeTransaction 전용 경로)
    @PostMapping("/calculateTaxForSaleTransaction")
    public Tax calculateTaxForSaleTransaction(@RequestBody ExchangeTransaction exchangeTransaction) {
        return exchangeTransactionService.calculateTaxForSaleTransaction(exchangeTransaction);
    }
}
