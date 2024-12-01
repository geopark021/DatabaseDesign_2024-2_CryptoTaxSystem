package com.cryptotaxsystem.backend.repository;

import com.cryptotaxsystem.backend.entity.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Integer> {
    // 사용자가 가지고 있는 지갑의 거래 내역을 조회
    List<WalletTransaction> findByUserIdAndWalletId(Integer userId, Integer walletId);
}
