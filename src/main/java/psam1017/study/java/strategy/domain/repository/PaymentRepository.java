package psam1017.study.java.strategy.domain.repository;

import psam1017.study.java.strategy.domain.Payment;

public interface PaymentRepository {
    Payment save(Payment payment);
}
