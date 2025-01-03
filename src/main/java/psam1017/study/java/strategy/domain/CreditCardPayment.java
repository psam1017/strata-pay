package psam1017.study.java.strategy.domain;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DiscriminatorValue("CREDIT_CARD")
@Entity
public class CreditCardPayment extends Payment {

    private String cardNumber;
    private String cardHolderName;
    private String approvalCode;

    @Builder
    protected CreditCardPayment(Long userId, int amount, String cardNumber, String cardHolderName, String approvalCode) {
        super(userId, amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.approvalCode = approvalCode;
    }
}
