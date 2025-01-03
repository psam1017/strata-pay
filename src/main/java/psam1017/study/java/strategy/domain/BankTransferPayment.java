package psam1017.study.java.strategy.domain;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DiscriminatorValue("BANK_TRANSFER")
@Entity
public class BankTransferPayment extends Payment {

    private String bankName;
    private String accountNumber;

    @Builder
    protected BankTransferPayment(Long userId, int amount, String bankName, String accountNumber) {
        super(userId, amount);
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }
}