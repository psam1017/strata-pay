package psam1017.study.java.strategy.domain.strategy;

import org.springframework.stereotype.Component;
import psam1017.study.java.strategy.domain.CreditCardPayment;
import psam1017.study.java.strategy.domain.Payment;
import psam1017.study.java.strategy.domain.PaymentCommand;

@Component
public class CreditCardStrategy implements PaymentStrategy {

    @Override
    public String getMethodName() {
        return "CREDIT_CARD";
    }

    @Override
    public Payment createPayment(PaymentCommand command) {
        // paymentInfo 예: "1111-2222-3333-4444|홍길동|승인코드123"
        String[] tokens = command.paymentInfo().split("\\|");
        String cardNumber = tokens[0];
        String cardHolderName = tokens[1];
        String approvalCode = tokens[2];
        return CreditCardPayment.builder()
                .userId(command.userId())
                .amount(command.amount())
                .cardNumber(cardNumber)
                .cardHolderName(cardHolderName)
                .approvalCode(approvalCode)
                .build();
    }
}
