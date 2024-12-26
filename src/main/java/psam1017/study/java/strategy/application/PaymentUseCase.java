package psam1017.study.java.strategy.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import psam1017.study.java.strategy.domain.*;
import psam1017.study.java.strategy.domain.strategy.PaymentStrategy;
import psam1017.study.java.strategy.domain.strategy.PaymentStrategySelector;

@RequiredArgsConstructor
@Component
public class PaymentUseCase {

    private final PaymentService paymentService;
    private final PaymentStrategySelector strategySelector;

    public Long executePayment(PaymentCommand command) {
        PaymentStrategy strategy = strategySelector.select(command.paymentMethod());
        Payment payment = strategy.createPayment(command);
        return paymentService.save(payment);
    }
}
