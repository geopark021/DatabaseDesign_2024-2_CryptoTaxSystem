package com.cryptotaxsystem.backend.service;

import com.cryptotaxsystem.backend.entity.WalletTransaction;
import com.cryptotaxsystem.backend.repository.WalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;

    @Autowired
    public WalletTransactionService(WalletTransactionRepository walletTransactionRepository) {
        this.walletTransactionRepository = walletTransactionRepository;
    }

    // 사용자의 지갑 거래 내역을 조회
    public List<WalletTransaction> getWalletTransactions(Integer userId, Integer walletId) {
        return walletTransactionRepository.findByUserIdAndWalletId(userId, walletId);
    }
}
