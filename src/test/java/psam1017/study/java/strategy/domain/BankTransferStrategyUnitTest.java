package psam1017.study.java.strategy.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import psam1017.study.java.strategy.domain.strategy.BankTransferStrategy;

import static org.assertj.core.api.Assertions.*;

public class BankTransferStrategyUnitTest {

    BankTransferStrategy bankTransferStrategy = new BankTransferStrategy();

    @DisplayName("은행송금의 결제방법은 BANK_TRANSFER 여야 한다.")
    @Test
    void getMethodName() {
        // when
        String methodName = bankTransferStrategy.getMethodName();

        // then
        assertThat(methodName).isEqualTo("BANK_TRANSFER");
    }

    @DisplayName("은행송금의 결제정보를 생성할 수 있다.")
    @Test
    void createPayment() {
        // given
        PaymentCommand command = new PaymentCommand(1L, 1000, "BANK_TRANSFER", "우리은행|123-456-7890");

        // when
        Payment payment = bankTransferStrategy.createPayment(command);

        // then
        assertThat(payment.getUserId()).isEqualTo(1L);
        assertThat(payment.getAmount()).isEqualTo(1000);
        assertThat(payment).isInstanceOf(BankTransferPayment.class);
        BankTransferPayment bankTransferPayment = (BankTransferPayment) payment;
        assertThat(bankTransferPayment.getBankName()).isEqualTo("우리은행");
        assertThat(bankTransferPayment.getAccountNumber()).isEqualTo("123-456-7890");
    }
}
