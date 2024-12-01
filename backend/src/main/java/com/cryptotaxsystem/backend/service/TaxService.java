package com.cryptotaxsystem.backend.service;

import com.cryptotaxsystem.backend.entity.Tax;
import com.cryptotaxsystem.backend.repository.TaxRepository;
import com.cryptotaxsystem.backend.repository.ExchangeTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaxService {

    @Autowired
    private TaxRepository taxRepository;

    @Autowired
    private ExchangeTransactionRepository exchangeTransactionRepository;

    // 선입선출(FIFO) 방식으로 세금 계산
    public Tax calculateTaxForSaleTransaction(ExchangeTransaction exchangeTransaction) {
        // 매도된 거래의 세금 계산을 위해 해당 코인의 매수 내역을 가져옵니다.
        List<ExchangeTransaction> purchaseTransactions = exchangeTransactionRepository
                .findByUserIdAndCoinIdAndTxTypeAndExecutionTimestampBefore(
                        exchangeTransaction.getUser().getId(),
                        exchangeTransaction.getCoin().getId(),
                        "매수",
                        exchangeTransaction.getExecutionTimestamp()
                );

        BigDecimal totalAcquisitionCost = BigDecimal.ZERO;
        BigDecimal totalSaleAmount = exchangeTransaction.getTradeAmount();
        BigDecimal remainingAmount = exchangeTransaction.getCoinAmount();

        for (ExchangeTransaction purchaseTransaction : purchaseTransactions) {
            if (remainingAmount.compareTo(BigDecimal.ZERO) <= 0) break;

            // 매수 내역에서 매도한 금액을 차감
            BigDecimal purchaseAmount = purchaseTransaction.getCoinAmount();
            BigDecimal purchaseCost = purchaseTransaction.getAcquisitionCost();
            if (purchaseAmount.compareTo(remainingAmount) > 0) {
                // 매도된 양이 매수된 양보다 적으면 비례하여 원가를 계산
                totalAcquisitionCost = totalAcquisitionCost.add(remainingAmount.multiply(purchaseCost).divide(purchaseAmount, 18, BigDecimal.ROUND_HALF_UP));
                remainingAmount = BigDecimal.ZERO;
            } else {
                totalAcquisitionCost = totalAcquisitionCost.add(purchaseCost);
                remainingAmount = remainingAmount.subtract(purchaseAmount);
            }
        }

        // 양도 차익 계산
        BigDecimal capitalGain = totalSaleAmount.subtract(totalAcquisitionCost);

        // 세금 계산 (예시: 22% 세율)
        BigDecimal taxRate = new BigDecimal("0.22");
        BigDecimal calculatedTax = capitalGain.multiply(taxRate);

        // 세금 납부 기한 설정 (예: 거래일로부터 1개월 후)
        LocalDateTime taxPaymentDueDate = LocalDateTime.now().plusMonths(1);

        // Tax 엔티티 생성 및 저장
        Tax tax = new Tax();
        tax.setExchangeTransaction(exchangeTransaction);
        tax.setTxSrcType("exchange");
        tax.setAcquisitionCost(totalAcquisitionCost);
        tax.setCalculatedTax(calculatedTax);
        tax.setTaxPaymentDueDate(taxPaymentDueDate);

        // 세금 정보를 DB에 저장
        return taxRepository.save(tax);
    }
}
