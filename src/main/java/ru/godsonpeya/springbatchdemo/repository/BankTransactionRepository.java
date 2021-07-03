package ru.godsonpeya.springbatchdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.godsonpeya.springbatchdemo.entity.BankTransaction;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long> {
}
