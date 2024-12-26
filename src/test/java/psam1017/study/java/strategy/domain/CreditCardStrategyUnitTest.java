package psam1017.study.java.strategy.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import psam1017.study.java.strategy.domain.strategy.CreditCardStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CreditCardStrategyUnitTest {

    CreditCardStrategy creditCardStrategy = new CreditCardStrategy();

    @DisplayName("신용카드의 결제방법은 CREDIT_CARD 여야 한다.")
    @Test
    void getMethodName() {
        // when
        String methodName = creditCardStrategy.getMethodName();

        // then
        assertThat(methodName).isEqualTo("CREDIT_CARD");
    }

    @DisplayName("신용카드의 결제정보를 생성할 수 있다.")
    @Test
    void createPayment() {
        // given
        PaymentCommand command = new PaymentCommand(1L, 1000, "CREDIT_CARD", "1111-2222-3333-4444|홍길동|승인코드123");

        // when
        Payment payment = creditCardStrategy.createPayment(command);

        // then
        assertThat(payment.getUserId()).isEqualTo(1L);
        assertThat(payment.getAmount()).isEqualTo(1000);
        assertThat(payment).isInstanceOf(CreditCardPayment.class);
        CreditCardPayment creditCardPayment = (CreditCardPayment) payment;
        assertThat(creditCardPayment.getCardNumber()).isEqualTo("1111-2222-3333-4444");
        assertThat(creditCardPayment.getCardHolderName()).isEqualTo("홍길동");
        assertThat(creditCardPayment.getApprovalCode()).isEqualTo("승인코드123");
    }
}
