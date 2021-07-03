package ru.godsonpeya.springbatchdemo.batch;

import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import ru.godsonpeya.springbatchdemo.entity.BankTransaction;
import ru.godsonpeya.springbatchdemo.repository.BankTransactionRepository;

import java.util.List;

@Component
@AllArgsConstructor
public class BankTransactionItemWritter implements ItemWriter<BankTransaction> {

    private final BankTransactionRepository bankTransactionRepository;

    @Override
    public void write(List<? extends BankTransaction> list) {
        bankTransactionRepository.saveAll(list);
    }
}
