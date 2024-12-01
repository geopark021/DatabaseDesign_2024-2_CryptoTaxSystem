package com.cryptotaxsystem.backend.controller;

import com.cryptotaxsystem.backend.entity.WalletTransaction;
import com.cryptotaxsystem.backend.service.WalletTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class WalletTransactionController {

    private final WalletTransactionService walletTransactionService;

    @Autowired
    public WalletTransactionController(WalletTransactionService walletTransactionService) {
        this.walletTransactionService = walletTransactionService;
    }

    // 사용자가 등록한 지갑의 거래 내역 조회
    @GetMapping("/wallettransactions/user/{userId}/wallet/{walletId}")
    public List<WalletTransaction> getWalletTransactions(
            @PathVariable Integer userId,
            @PathVariable Integer walletId) {
        return walletTransactionService.getWalletTransactions(userId, walletId);
    }
}
