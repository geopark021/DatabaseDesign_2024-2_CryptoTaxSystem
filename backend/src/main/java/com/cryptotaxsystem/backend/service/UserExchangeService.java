package com.cryptotaxsystem.backend.service;

import com.cryptotaxsystem.backend.dto.UserExchangeDTO;
import com.cryptotaxsystem.backend.entity.User;
import com.cryptotaxsystem.backend.entity.UserExchange;
import com.cryptotaxsystem.backend.entity.Exchange;
import com.cryptotaxsystem.backend.repository.UserRepository;
import com.cryptotaxsystem.backend.repository.ExchangeRepository;
import com.cryptotaxsystem.backend.repository.UserExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserExchangeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Autowired
    private UserExchangeRepository userExchangeRepository;

    // 거래소 등록 로직
    public String registerExchange(UserExchangeDTO userExchangeDTO, String email) {
        // 사용자 정보 확인
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return "User not found with email: " + email;
        }
        User user = userOptional.get();

        // 거래소 정보 확인
        Optional<Exchange> exchangeOptional = exchangeRepository.findById(userExchangeDTO.getExchangeId());
        if (exchangeOptional.isEmpty()) {
            return "Exchange not found with id: " + userExchangeDTO.getExchangeId();
        }
        Exchange exchange = exchangeOptional.get();

        // 이미 해당 사용자와 거래소의 정보가 존재하는지 확인
        Optional<UserExchange> existingUserExchange = userExchangeRepository
                .findByUserIdAndExchangeId(user.getId(), exchange.getId());
        if (existingUserExchange.isPresent()) {
            return "Exchange information already registered for this user.";
        }

        // 새로운 UserExchange 객체 생성 및 저장
        UserExchange userExchange = new UserExchange();
        userExchange.setUserId(user.getId());
        userExchange.setExchangeId(exchange.getId());
        userExchange.setApiName(userExchangeDTO.getApiName());
        userExchange.setApiKey(userExchangeDTO.getApiKey());
        userExchange.setApiSecretKey(userExchangeDTO.getApiSecretKey());
        userExchange.setApiRegisteredAt(LocalDateTime.now());

        userExchangeRepository.save(userExchange);

        return "Exchange registered successfully.";
    }
}
