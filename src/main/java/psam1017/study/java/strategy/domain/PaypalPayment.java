package psam1017.study.java.strategy.domain;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DiscriminatorValue("PAYPAL")
@Entity
public class PaypalPayment extends Payment {

    private String paypalAccount;
    private String transactionId;

    @Builder
    protected PaypalPayment(Long userId, int amount, String paypalAccount, String transactionId) {
        super(userId, amount);
        this.paypalAccount = paypalAccount;
        this.transactionId = transactionId;
    }
}