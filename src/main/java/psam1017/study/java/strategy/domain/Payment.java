package psam1017.study.java.strategy.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "payment_method")
@Entity
public abstract class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private int amount;

    @Column(name = "payment_method", insertable = false, updatable = false)
    private String paymentMethod;

    protected Payment(Long userId, int amount) {
        this.userId = userId;
        this.amount = amount;
    }
}
