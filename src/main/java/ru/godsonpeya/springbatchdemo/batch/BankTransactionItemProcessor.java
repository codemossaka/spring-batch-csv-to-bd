package ru.godsonpeya.springbatchdemo.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import ru.godsonpeya.springbatchdemo.entity.BankTransaction;

import java.text.SimpleDateFormat;

@Component
public class BankTransactionItemProcessor implements ItemProcessor<BankTransaction, BankTransaction> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm");

    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
        bankTransaction.setTransactionDate(dateFormat.parse(bankTransaction.getStrTransactionDate()));
        return bankTransaction;
    }
}
