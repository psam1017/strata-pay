package psam1017.study.java.strategy.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import psam1017.study.java.strategy.ApplicationTests;
import psam1017.study.java.strategy.infrastructure.repository.jpa.PaymentJpaRepository;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentServiceUnitTest extends ApplicationTests {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentJpaRepository paymentJpaRepository;

    @DisplayName("CreditCardPayment 를 저장할 수 있다.")
    @Test
    void saveCreditCardPayment() {
        // given
        CreditCardPayment buildPayment = CreditCardPayment.builder()
                .userId(1L)
                .amount(1000)
                .cardNumber("1111-2222-3333-4444")
                .cardHolderName("예금주")
                .approvalCode("OK")
                .build();

        // when
        Long savedId = paymentService.save(buildPayment);

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

    @DisplayName("BankTransferPayment 를 저장할 수 있다.")
    @Test
    void saveBankTransferPayment() {
        // given
        BankTransferPayment buildPayment = BankTransferPayment.builder()
                .userId(1L)
                .amount(1000)
                .bankName("우리은행")
                .accountNumber("123-456-7890")
                .build();

        // when
        Long savedId = paymentService.save(buildPayment);

        // then
        Payment findPayment = paymentJpaRepository.findById(savedId).orElseThrow();
        assertThat(findPayment.getUserId()).isEqualTo(1L);
        assertThat(findPayment.getAmount()).isEqualTo(1000);
        assertThat(findPayment).isInstanceOf(BankTransferPayment.class);
        BankTransferPayment findBankTransferPayment = (BankTransferPayment) findPayment;
        assertThat(findBankTransferPayment.getBankName()).isEqualTo("우리은행");
        assertThat(findBankTransferPayment.getAccountNumber()).isEqualTo("123-456-7890");
    }

    @DisplayName("PaypalPayment 를 저장할 수 있다.")
    @Test
    void savePaypalPayment() {
        // given
        PaypalPayment buildPayment = PaypalPayment.builder()
                .userId(1L)
                .amount(1000)
                .paypalAccount("test@paypal.com")
                .transactionId("txn_abc123")
                .build();

        // when
        Long savedId = paymentService.save(buildPayment);

        // then
        Payment findPayment = paymentJpaRepository.findById(savedId).orElseThrow();
        assertThat(findPayment.getUserId()).isEqualTo(1L);
        assertThat(findPayment.getAmount()).isEqualTo(1000);
        assertThat(findPayment).isInstanceOf(PaypalPayment.class);
        PaypalPayment findPaypalPayment = (PaypalPayment) findPayment;
        assertThat(findPaypalPayment.getPaypalAccount()).isEqualTo("test@paypal.com");
        assertThat(findPaypalPayment.getTransactionId()).isEqualTo("txn_abc123");
    }
}
