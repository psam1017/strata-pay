package psam1017.study.java.strategy.presentation;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import psam1017.study.java.strategy.application.PaymentUseCase;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payments")
public class PayController {

    private final PaymentUseCase paymentUseCase;

    /**
     * 결제 요청 (카드, 페이팔, 은행이체 등 다양한 결제 전략 활용)
     */
    @PostMapping
    public Long pay(@RequestBody PaymentRequest request) {
        return paymentUseCase.executePayment(request.toCommand());
    }
}