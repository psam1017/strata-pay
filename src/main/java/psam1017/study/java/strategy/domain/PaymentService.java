package psam1017.study.java.strategy.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import psam1017.study.java.strategy.domain.repository.PaymentRepository;

@RequiredArgsConstructor
@Transactional
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Long save(Payment payment) {
        return paymentRepository.save(payment).getId();
    }
}
