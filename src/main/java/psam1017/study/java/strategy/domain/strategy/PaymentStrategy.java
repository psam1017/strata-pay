package psam1017.study.java.strategy.domain.strategy;

import psam1017.study.java.strategy.domain.Payment;
import psam1017.study.java.strategy.domain.PaymentCommand;

public interface PaymentStrategy {

    String getMethodName();
    Payment createPayment(PaymentCommand command);
}
