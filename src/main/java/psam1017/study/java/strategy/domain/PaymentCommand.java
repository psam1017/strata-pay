package psam1017.study.java.strategy.domain;

public record PaymentCommand(
        Long userId,
        int amount,
        String paymentMethod,
        String paymentInfo
) {

}
