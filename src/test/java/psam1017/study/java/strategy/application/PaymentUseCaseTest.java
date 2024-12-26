package psam1017.study.java.strategy.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import psam1017.study.java.strategy.ApplicationTests;
import psam1017.study.java.strategy.domain.*;
import psam1017.study.java.strategy.infrastructure.repository.jpa.PaymentJpaRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentUseCaseTest extends ApplicationTests {

    @Autowired
    PaymentUseCase paymentUseCase;

    @Autowired
    PaymentJpaRepository paymentJpaRepository;

    @DisplayName("신용카드 결제 요청에 따라 CreditCardPayment 를 저장할 수 있다.")
    @Test
    void executeCreditCardPayment() {
        // given
        PaymentCommand command = new PaymentCommand(1L, 1000, "CREDIT_CARD", "1111-2222-3333-4444|예금주|OK");

        // when
        Long savedId = paymentUseCase.executePayment(command);

        // then
        Payment findPayment = paymentJpaRepository.findById(savedId).orElseThrow();
        assertThat(findPayment.getUserId()).isEqualTo(1L);
        assertThat(findPayment.getAmount()).isEqualTo(1000);
        assertThat(findPayment).isInstanceOf(CreditCardPayment.class);
        CreditCardPayment findCreditCardPayment = (CreditCardPayment) findPayment;
        assertThat(findCreditCardPayment.getCardNumber()).isEqualTo("1111-2222-3333-4444");
        assertThat(findCreditCardPayment.getCardHolderName()).isEqualTo("예금주");
        assertThat(findCreditCardPayment.getApprovalCode()).isEqualTo("OK");
    }

    @DisplayName("페이팔 결제 요청에 따라 PaypalPayment 를 저장할 수 있다.")
    @Test
    void executePaypalPayment() {
        // given
        PaymentCommand command = new PaymentCommand(1L, 1000, "PAYPAL", "test@paypal.com|txn_abc123");

        // when
        Long savedId = paymentUseCase.executePayment(command);

        // then
        Payment findPayment = paymentJpaRepository.findById(savedId).orElseThrow();
        assertThat(findPayment.getUserId()).isEqualTo(1L);
        assertThat(findPayment.getAmount()).isEqualTo(1000);
        assertThat(findPayment).isInstanceOf(PaypalPayment.class);
        PaypalPayment findPaypalPayment = (PaypalPayment) findPayment;
        assertThat(findPaypalPayment.getPaypalAccount()).isEqualTo("test@paypal.com");
        assertThat(findPaypalPayment.getTransactionId()).isEqualTo("txn_abc123");
    }

    @DisplayName("은행송금 결제 요청에 따라 BankTransferPayment 를 저장할 수 있다.")
    @Test
    void executeBankTransferPayment() {
        // given
        PaymentCommand command = new PaymentCommand(1L, 1000, "BANK_TRANSFER", "우리은행|123-456-7890");

        // when
        Long savedId = paymentUseCase.executePayment(command);

        // then
        Payment findPayment = paymentJpaRepository.findById(savedId).orElseThrow();
        assertThat(findPayment.getUserId()).isEqualTo(1L);
        assertThat(findPayment.getAmount()).isEqualTo(1000);
        assertThat(findPayment).isInstanceOf(BankTransferPayment.class);
        BankTransferPayment findBankTransferPayment = (BankTransferPayment) findPayment;
        assertThat(findBankTransferPayment.getBankName()).isEqualTo("우리은행");
        assertThat(findBankTransferPayment.getAccountNumber()).isEqualTo("123-456-7890");
    }
}
