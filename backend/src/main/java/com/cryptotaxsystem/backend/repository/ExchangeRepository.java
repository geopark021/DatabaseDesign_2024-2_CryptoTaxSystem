package com.cryptotaxsystem.backend.repository;

import com.cryptotaxsystem.backend.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {
    // 기본적인 CRUD 메서드가 자동으로 제공됩니다.
}
