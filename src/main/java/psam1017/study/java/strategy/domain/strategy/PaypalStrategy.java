package psam1017.study.java.strategy.domain.strategy;

import org.springframework.stereotype.Component;
import psam1017.study.java.strategy.domain.Payment;
import psam1017.study.java.strategy.domain.PaymentCommand;
import psam1017.study.java.strategy.domain.PaypalPayment;

@Component
public class PaypalStrategy implements PaymentStrategy {

    @Override
    public String getMethodName() {
        return "PAYPAL";
    }

    @Override
    public Payment createPayment(PaymentCommand command) {
        // paymentInfo 예: "test@paypal.com|txn_abc123"
        String[] tokens = command.paymentInfo().split("\\|");
        String paypalAccount = tokens[0];
        String transactionId = tokens[1];
        return PaypalPayment.builder()
                .userId(command.userId())
                .amount(command.amount())
                .paypalAccount(paypalAccount)
                .transactionId(transactionId)
                .build();
    }
}
