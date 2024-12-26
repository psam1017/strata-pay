package psam1017.study.java.strategy.domain.strategy;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PaymentStrategySelector {

    private final List<PaymentStrategy> strategies;
    private final Map<String, PaymentStrategy> strategyMap = new HashMap<>();

    @PostConstruct
    public void init() {
        for (PaymentStrategy strategy : strategies) {
            strategyMap.put(strategy.getMethodName().toUpperCase(), strategy);
        }
    }

    public PaymentStrategy select(String method) {
        PaymentStrategy found = strategyMap.get(method.toUpperCase());
        if (found == null) {
            throw new IllegalArgumentException("지원하지 않는 결제 방식: " + method);
        }
        return found;
    }
}
