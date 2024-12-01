package com.cryptotaxsystem.backend.repository;

import com.cryptotaxsystem.backend.entity.UserExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserExchangeRepository extends JpaRepository<UserExchange, Integer> {
    // 사용자와 거래소 ID를 기반으로 이미 등록된 정보를 확인하는 메서드
    Optional<UserExchange> findByUserIdAndExchangeId(Integer userId, Integer exchangeId);
}
