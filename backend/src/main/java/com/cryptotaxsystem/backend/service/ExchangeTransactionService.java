package com.cryptotaxsystem.backend.service;

import com.cryptotaxsystem.backend.entity.Tax;
import com.cryptotaxsystem.backend.repository.ExchangeTransactionRepository;
import com.cryptotaxsystem.backend.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExchangeTransactionService {

    @Autowired
    private ExchangeTransactionRepository exchangeTransactionRepository;

    @Autowired
    private TaxRepository taxRepository;

    // 특정 사용자의 거래소에 대한 거래 내역 조회
    public List<ExchangeTransaction> getExchangeTransactionsByUserAndExchange(Integer userId, Integer exchangeId) {
        return exchangeTransactionRepository.findByUserIdAndExchangeId(userId, exchangeId);
    }

    // 특정 사용자의 모든 거래소에 대한 거래 내역 조회
    public List<ExchangeTransaction> getExchangeTransactionsByUser(Integer userId) {
        return exchangeTransactionRepository.findByUserId(userId);
    }

    // 매도 거래에 대해 선입선출 방식으로 세금 계산
    public Tax calculateTaxForSaleTransaction(ExchangeTransaction exchangeTransaction) {
        // 매도 거래에 대한 세금 계산을 위해 매수 거래 내역 조회 (FIFO 방식)
        List<ExchangeTransaction> purchaseTransactions = exchangeTransactionRepository
                .findByUserIdAndCoinIdAndTxTypeAndExecutionTimestampBefore(
                        exchangeTransaction.getUser().getId(),
                        exchangeTransaction.getCoin().getId(),
                        "매수",  // 매수 거래만 조회
                        exchangeTransaction.getExecutionTimestamp());

        BigDecimal totalAcquisitionCost = BigDecimal.ZERO;
        BigDecimal totalAmountSold = exchangeTransaction.getTradeAmount();
        BigDecimal remainingAmountToSell = totalAmountSold;

        for (ExchangeTransaction purchaseTransaction : purchaseTransactions) {
            BigDecimal purchaseAmount = purchaseTransaction.getCoinAmount();
            BigDecimal purchaseCost = purchaseTransaction.getAcquisitionCost();

            // 매도할 금액만큼 매수 금액 차감
            if (remainingAmountToSell.compareTo(purchaseAmount) <= 0) {
                totalAcquisitionCost = totalAcquisitionCost.add(purchaseCost.multiply(remainingAmountToSell).divide(purchaseAmount, 18, BigDecimal.ROUND_HALF_UP));
                break; // 더 이상 매도할 잔액이 없으면 종료
            } else {
                totalAcquisitionCost = totalAcquisitionCost.add(purchaseCost);
                remainingAmountToSell = remainingAmountToSell.subtract(purchaseAmount);
            }
        }

        // 세금 계산 (예시로 22% 세율 적용)
        BigDecimal taxRate = new BigDecimal("0.22");
        BigDecimal calculatedTax = totalAcquisitionCost.multiply(taxRate);

        // 새로운 Tax 엔티티 생성 및 값 설정
        Tax tax = new Tax();
        tax.setWalletTransaction(exchangeTransaction.getWalletTransaction()); // WalletTransaction이 연관된 경우
        tax.setExchangeTransaction(exchangeTransaction);
        tax.setTxSrcType("거래소"); // 거래소에서의 거래라고 가정
        tax.setTaxPaymentDueDate(LocalDateTime.now()); // 세금 납부 기한 (예시로 현재 시간 설정)
        tax.setAcquisitionCost(totalAcquisitionCost);
        tax.setCalculatedTax(calculatedTax);

        // 세금 정보 저장
        return taxRepository.save(tax);
    }
}
