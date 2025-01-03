package psam1017.study.java.strategy.presentation;

import psam1017.study.java.strategy.domain.PaymentCommand;

public record PaymentRequest(
        Long userId,
        int amount,
        String paymentMethod,
        String paymentInfo
) {

    public PaymentCommand toCommand() {
        return new PaymentCommand(userId(), amount(), paymentMethod(), paymentInfo());
    }
}
