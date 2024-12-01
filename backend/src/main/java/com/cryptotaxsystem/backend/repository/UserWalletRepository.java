package com.cryptotaxsystem.backend.repository;

import com.cryptotaxsystem.backend.entity.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletRepository extends JpaRepository<UserWallet, Integer> {
}
