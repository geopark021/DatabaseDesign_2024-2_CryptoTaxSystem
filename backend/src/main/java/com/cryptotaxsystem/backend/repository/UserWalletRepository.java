package com.cryptotaxsystem.backend.repository;

import com.cryptotaxsystem.backend.entity.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWalletRepository extends JpaRepository<UserWallet, Integer> {
    // 필요한 쿼리 메서드 추가 가능
}
