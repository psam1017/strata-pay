package psam1017.study.java.strategy.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import psam1017.study.java.strategy.domain.Payment;
import psam1017.study.java.strategy.domain.repository.PaymentRepository;
import psam1017.study.java.strategy.infrastructure.repository.jpa.PaymentJpaRepository;

@RequiredArgsConstructor
@Transactional
@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public Payment save(Payment payment) {
        return paymentJpaRepository.save(payment);
    }
}
