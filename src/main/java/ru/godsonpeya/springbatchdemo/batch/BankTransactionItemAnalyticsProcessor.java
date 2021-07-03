package ru.godsonpeya.springbatchdemo.batch;

import lombok.Getter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import ru.godsonpeya.springbatchdemo.entity.BankTransaction;

@Component
public class BankTransactionItemAnalyticsProcessor implements ItemProcessor<BankTransaction, BankTransaction> {

    @Getter
    private double totalDebit;

    @Getter
    private double totalCredit;

    @Override
    public BankTransaction process(BankTransaction bankTransaction) {
        if (bankTransaction.getTransactionType().startsWith("C")) totalDebit += bankTransaction.getAmount();
        else totalCredit += bankTransaction.getAmount();
        return bankTransaction;
    }
}
