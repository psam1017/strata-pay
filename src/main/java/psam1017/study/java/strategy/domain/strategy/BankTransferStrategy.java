package psam1017.study.java.strategy.domain.strategy;

import org.springframework.stereotype.Component;
import psam1017.study.java.strategy.domain.BankTransferPayment;
import psam1017.study.java.strategy.domain.Payment;
import psam1017.study.java.strategy.domain.PaymentCommand;

@Component
public class BankTransferStrategy implements PaymentStrategy {

    @Override
    public String getMethodName() {
        return "BANK_TRANSFER";
    }

    @Override
    public Payment createPayment(PaymentCommand command) {
        // paymentInfo 예: "우리은행|123-456-7890"
        String[] tokens = command.paymentInfo().split("\\|");
        String bankName = tokens[0];
        String accountNumber = tokens[1];
        return BankTransferPayment.builder()
                .userId(command.userId())
                .amount(command.amount())
                .bankName(bankName)
                .accountNumber(accountNumber)
                .build();
    }
}
