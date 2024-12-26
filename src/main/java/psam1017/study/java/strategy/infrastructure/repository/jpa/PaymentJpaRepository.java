package psam1017.study.java.strategy.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import psam1017.study.java.strategy.domain.Payment;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {
}
