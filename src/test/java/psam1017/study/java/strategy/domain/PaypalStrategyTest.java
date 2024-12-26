package psam1017.study.java.strategy.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import psam1017.study.java.strategy.domain.strategy.CreditCardStrategy;
import psam1017.study.java.strategy.domain.strategy.PaypalStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class PaypalStrategyTest {

    PaypalStrategy paypalStrategy = new PaypalStrategy();

    @DisplayName("페이팔의 결제방법은 PAYPAL 여야 한다.")
    @Test
    void getMethodName() {
        // when
        String methodName = paypalStrategy.getMethodName();

        // then
        assertThat(methodName).isEqualTo("PAYPAL");
    }

    @DisplayName("페이팔의 결제정보를 생성할 수 있다.")
    @Test
    void createPayment() {
        // given
        PaymentCommand command = new PaymentCommand(1L, 1000, "PAYPAL", "test@paypal.com|txn_abc123");

        // when
        Payment payment = paypalStrategy.createPayment(command);

        // then
        assertThat(payment.getUserId()).isEqualTo(1L);
        assertThat(payment.getAmount()).isEqualTo(1000);
        assertThat(payment).isInstanceOf(PaypalPayment.class);
        PaypalPayment paypalPayment = (PaypalPayment) payment;
        assertThat(paypalPayment.getPaypalAccount()).isEqualTo("test@paypal.com");
        assertThat(paypalPayment.getTransactionId()).isEqualTo("txn_abc123");
    }
}
